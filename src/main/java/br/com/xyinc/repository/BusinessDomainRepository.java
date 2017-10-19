package br.com.xyinc.repository;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manuele on 18/10/17.
 */
public interface BusinessDomainRepository extends JpaRepository<BusinessDomain, Long> {

    BusinessDomain findByName(String name);

}
