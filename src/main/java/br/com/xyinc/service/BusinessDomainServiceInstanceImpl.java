package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainInstanceRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Component("businessDomainInstanceService")
@Transactional
public class BusinessDomainServiceInstanceImpl implements BusinessDomainInstanceService {

    private final BusinessDomainInstanceRepository businessDomainInstanceRepository;

    public BusinessDomainServiceInstanceImpl(BusinessDomainInstanceRepository instance){
        this.businessDomainInstanceRepository = instance;
    }

//    @Override
//    public void addBusinessDomainInstance(BusinessDomainInstance businessDomainInstance)
//    {
//        this.businessDomainRepository.save(BusinessDomainInstance);
//    }

    @Transactional(readOnly = true)
    public List<BusinessDomainInstance> getAllInstancesByBusinessDomain(BusinessDomain businessDomain)
    {
        return this.businessDomainInstanceRepository.findByBusinessDomain(businessDomain);
    }

    @Transactional(readOnly = true)
    public BusinessDomainInstance getBusinessDomainInstanceByNameAndId(BusinessDomain businessDomain,
                                                                Long businessDomainInstanceId) {
        return this.businessDomainInstanceRepository.findByBusinessDomainAndId(businessDomain,
                businessDomainInstanceId);
    }
}
