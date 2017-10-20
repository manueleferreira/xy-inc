package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.service.BusinessDomainInstanceService;
import br.com.xyinc.service.BusinessDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@RestController
@RequestMapping("/{businessDomainName}")
public class BusinessDomainInstanceController {

    @Autowired
    private BusinessDomainInstanceService businessDomainInstanceService;

    @Autowired
    private BusinessDomainService businessDomainService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BusinessDomainInstance> getAllBusinessDomainInstanceByName(@PathVariable String businessDomainName) {
        BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
        return businessDomainInstanceService.getAllInstancesByBusinessDomain(businessDomain);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{businessDomainInstanceId}")
    public BusinessDomainInstance getBusinessDomainInstanceByNameAndId(@PathVariable String businessDomainName,
                                                                @PathVariable Long businessDomainInstanceId) {
        return businessDomainInstanceService.getBusinessDomainInstanceById(businessDomainInstanceId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createBusinessDomainInstance(@PathVariable String businessDomainName)
    {
        try
        {
            BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
            BusinessDomainInstance businessDomainInstance = new BusinessDomainInstance();
            businessDomainInstance.setBusinessDomain(businessDomain);

            businessDomainInstanceService.createBusinessDomainInstance(businessDomainInstance);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
