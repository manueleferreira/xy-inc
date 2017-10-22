package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainRepository;
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

    @Transactional(readOnly = true)
    public List<BusinessDomain> getAllBusinessDomains()
    {
        return this.businessDomainRepository.findAll();
    }

    @Override
    public BusinessDomain createBusinessDomain(BusinessDomain model)
    {
        return this.businessDomainRepository.save(model);
    }

    @Transactional(readOnly = true)
    public void deleteBusinessDomainById(Long id) {
        this.businessDomainRepository.delete(id);
    }
}
