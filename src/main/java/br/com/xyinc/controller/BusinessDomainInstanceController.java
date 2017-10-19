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
        BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
        return businessDomainInstanceService.getBusinessDomainInstanceByNameAndId(businessDomain,
                businessDomainInstanceId);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void createBusinessDomain(@PathVariable String businessDomainName,
//                                     @PathVariable String name,
//                                     @PathVariable String type)
//    {
//        try
//        {
//            BusinessDomain businessDomain = businessDomainService.getBusinessDomainByName(businessDomainName);
//            BusinessDomainInstance businessDomainInstance = new BusinessDomainInstance();
//            businessDomainInstance.setBusinessDomain(businessDomain);
//
//            BusinessDomainInstanceAtt businessDomainAtt = new BusinessDomainInstanceAtt();
//            businessDomainAtt.setBusinessDomain(businessDomain);
//            businessDomainAtt.setName(name);
//            businessDomainAtt.setType(type);
//
//            businessDomainService.addBusinessDomainInstance(businessDomainInstance,
//                    Stream.of(businessDomainAtt)
//                            .collect(Collectors.toCollection(ArrayList::new)));
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

}
