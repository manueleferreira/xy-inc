package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.service.BusinessDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping("/businessdomain")
public class BusinessDomainController {

    private static final Logger log = LoggerFactory.getLogger(BusinessDomainController.class);

    @Autowired
    private BusinessDomainService businessDomainService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public BusinessDomain createBusinessDomain(@RequestBody BusinessDomain model)
    {
        try
        {
            log.debug(" criando do dominio: {} ", model);
            return businessDomainService.createBusinessDomain(model);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        //TODO change this return to one that handles the exception message
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{businessDomainId}")
    public void deleteBusinessDomainById(@PathVariable Long businessDomainId) {

        log.debug(" deletando instancia do dominio: id: {}", businessDomainId);
        businessDomainService.deleteBusinessDomainById(businessDomainId);
    }

}
