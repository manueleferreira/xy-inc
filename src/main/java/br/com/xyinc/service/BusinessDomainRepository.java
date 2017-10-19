package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by manuele on 18/10/17.
 */
public interface BusinessDomainRepository extends JpaRepository<BusinessDomain, Long> {

    BusinessDomain findByName(String name);

    BusinessDomainInstance findByBusinessModelIdAndInstanceId(Long businessDomainNameId,
                                                              Long businessDomainInstanceId);

}
