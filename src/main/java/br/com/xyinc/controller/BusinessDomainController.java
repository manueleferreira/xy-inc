package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.service.BusinessDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping("/{businessDomainName}")
public class BusinessDomainController {

    @Autowired
    private BusinessDomainService businessDomainService;

    @RequestMapping(method = RequestMethod.GET)
    public BusinessDomain readBusinessDomainByName(@PathVariable String businessDomainName) {
        return businessDomainService.getBusinessDomainByName(businessDomainName);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{businessDomainId}")
//    public BusinessDomain readBusinessDomainByNameAndId(@PathVariable String businessDomainName,
//                                                 @PathVariable Long businessDomainId) {
//        return businessDomainService.getBusinessDomainByName(businessDomainName);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String createBusinessDomain(@PathVariable String businessDomainName)
    {
        try
        {
            BusinessDomain businessDomain = new BusinessDomain();
            businessDomain.setName(businessDomainName);
            businessDomainService.addBusinessDomain(businessDomain);
            return "ok!";
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
