package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
public interface BusinessDomainInstanceService {

    List<BusinessDomainInstance> getAllInstancesByBusinessDomain(BusinessDomain businessDomain);

    BusinessDomainInstance getBusinessDomainInstanceById(Long businessDomainInstanceId);

}
