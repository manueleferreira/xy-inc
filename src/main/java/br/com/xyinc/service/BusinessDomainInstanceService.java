package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Service
public interface BusinessDomainInstanceService {

    List<BusinessDomainInstance> getAllInstancesByBusinessDomain(BusinessDomain businessDomain);

    BusinessDomainInstance getBusinessDomainInstanceById(Long businessDomainInstanceId);

    BusinessDomainInstance createBusinessDomainInstance(BusinessDomainInstance businessDomainInstance);

    void deleteBusinessDomainInstanceById(Long businessDomainInstanceId);

    void updateBusinessDomainInstance(BusinessDomainInstance businessDomainInstance);

}
