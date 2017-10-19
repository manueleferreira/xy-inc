package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Component("businessDomainService")
@Transactional
public class BusinessDomainServiceImpl implements BusinessDomainService {

    private final BusinessDomainRepository businessDomainRepository;

    public BusinessDomainServiceImpl(BusinessDomainRepository businessDomainRepository){
        this.businessDomainRepository = businessDomainRepository;
    }

    @Override
    public BusinessDomain getBusinessDomainByName(String name)
    {
        return this.businessDomainRepository.findByName(name);
    }

    @Override
    public BusinessDomainInstance getBusinessDomainInstancesById(String businessDomainName,
                                                          Long businessDomainInstanceId)
    {
        BusinessDomain businessDomain = this.businessDomainRepository.findByName(businessDomainName);
        return this.businessDomainRepository.findByBusinessModelIdAndInstanceId(businessDomain.getId(),
                businessDomainInstanceId);
    }

    @Override
    public void addBusinessDomainInstance(BusinessDomainInstance businessDomainInstance)
    {
        this.businessDomainRepository.save(BusinessDomainInstance);
    }

    @Transactional(readOnly = true)
    public List<BusinessDomain> getAllBusinessDomain()
    {
        return this.businessDomainRepository.findAll();
    }
}
