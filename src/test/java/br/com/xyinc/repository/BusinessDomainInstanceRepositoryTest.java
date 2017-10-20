package br.com.xyinc.repository;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by manuele on 19/10/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BusinessDomainInstanceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusinessDomainInstanceRepository businessDomainInstanceRepository;

    @Test
    public void whenFindByIdThenReturnBusinessDomainInstance() {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        entityManager.persist(businessDomain);
        entityManager.flush();

        BusinessDomainInstance instance = new BusinessDomainInstance();
        instance.setBusinessDomain(businessDomain);
        entityManager.persist(instance);
        entityManager.flush();

        BusinessDomainInstance found = businessDomainInstanceRepository.
                findById(instance.getId());

        assertThat(found.getId()).isEqualTo(instance.getId());
    }

    @Test
    public void whenFindByBusinessDomainThenReturnBusinessDomainInstance() {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        entityManager.persist(businessDomain);
        entityManager.flush();

        BusinessDomainInstance instance = new BusinessDomainInstance();
        instance.setBusinessDomain(businessDomain);
        entityManager.persist(instance);
        entityManager.flush();

        List<BusinessDomainInstance> foundList = businessDomainInstanceRepository.
                findByBusinessDomain(instance.getBusinessDomain());

        assertThat(foundList.size()).isEqualTo(1);
        assertThat(foundList.get(0).getId()).isEqualTo(instance.getId());
    }
}
