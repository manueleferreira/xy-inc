package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
public interface BusinessDomainService {

    BusinessDomain getBusinessDomainByName(String name);

    void addBusinessDomain(BusinessDomain BusinessDomain);

    List<BusinessDomain> getAllBusinessDomain();
    
}
