package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
@Component("businessDomainInstanceService")
@Transactional
public class BusinessDomainInstanceServiceImpl implements BusinessDomainInstanceService {

    private final BusinessDomainInstanceRepository businessDomainInstanceRepository;

    public BusinessDomainInstanceServiceImpl(BusinessDomainInstanceRepository repository){
        this.businessDomainInstanceRepository = repository;
    }

    @Override
    public void createBusinessDomainInstance(BusinessDomainInstance instance)
    {
        this.businessDomainInstanceRepository.save(instance);
    }

    @Transactional(readOnly = true)
    public List<BusinessDomainInstance> getAllInstancesByBusinessDomain(BusinessDomain businessDomain)
    {
        return this.businessDomainInstanceRepository.findByBusinessDomain(businessDomain);
    }

    @Transactional(readOnly = true)
    public BusinessDomainInstance getBusinessDomainInstanceById(Long id) {
        return this.businessDomainInstanceRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public void deleteBusinessDomainInstanceById(Long id) {
        this.businessDomainInstanceRepository.delete(id);
    }

}
