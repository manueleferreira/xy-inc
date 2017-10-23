package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.service.BusinessDomainInstanceService;
import br.com.xyinc.service.BusinessDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping(value = "api/{businessDomainName}", headers = "Accept=application/json")
public class BusinessDomainInstanceController {

    private static final Logger log = LoggerFactory.getLogger(BusinessDomainInstanceController.class);

    @Autowired
    private BusinessDomainInstanceService businessDomainInstanceService;

    @Autowired
    private BusinessDomainService businessDomainService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<BusinessDomainInstance> getAllBusinessDomainInstanceByName(@PathVariable String businessDomainName)
    {
        log.debug(" Consultando dominio: {} ", businessDomainName);
        BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
        return businessDomainInstanceService.getAllInstancesByBusinessDomain(businessDomain);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{businessDomainInstanceId}")
    public BusinessDomainInstance getBusinessDomainInstanceById(@PathVariable String businessDomainName,
                                                                @PathVariable Long businessDomainInstanceId) {
        log.debug(" Consultando dominio: {} e id {}", businessDomainName, businessDomainInstanceId);
        return businessDomainInstanceService.getBusinessDomainInstanceById(businessDomainInstanceId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public BusinessDomainInstance createBusinessDomainInstance(@PathVariable String businessDomainName,
                                                               @RequestBody BusinessDomainInstance instance)
    {
        try
        {
            log.debug(" criando do dominio: {} ", businessDomainName);
            BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
            instance.setBusinessDomain(businessDomain);

            return businessDomainInstanceService.createBusinessDomainInstance(instance);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        //TODO change this return to one that handles the exception message
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{businessDomainInstanceId}")
    public void deleteBusinessDomainInstanceById(@PathVariable String businessDomainName,
                                                 @PathVariable Long businessDomainInstanceId) {

        log.debug(" deletando instancia do dominio: {} id: {}", businessDomainName, businessDomainInstanceId);
        businessDomainInstanceService.deleteBusinessDomainInstanceById(businessDomainInstanceId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, value = "/{businessDomainInstanceId}")
    public void updateBusinessDomainInstanceById(@PathVariable String businessDomainName,
                                                 @PathVariable Long businessDomainInstanceId,
                                                 @RequestBody BusinessDomainInstance instance) {

        log.debug("editando instancia do dominio: {} id: {}", businessDomainName, businessDomainInstanceId);
        businessDomainInstanceService.updateBusinessDomainInstance(instance);
    }
}
