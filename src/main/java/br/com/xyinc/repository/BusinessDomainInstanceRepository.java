package br.com.xyinc.repository;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
public interface BusinessDomainInstanceRepository extends JpaRepository<BusinessDomainInstance, Long> {

    List<BusinessDomainInstance> findByBusinessDomain(BusinessDomain businessDomain);

    BusinessDomainInstance findByBusinessDomainAndId(BusinessDomain businessDomain, Long id);
}
