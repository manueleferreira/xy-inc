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
 * Created by manuele on 22/10/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class BusinessDomainRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusinessDomainRepository repository;

    @Test
    public void whenFindByNameThenReturnBusinessDomain() {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        entityManager.persist(businessDomain);
        entityManager.flush();

        BusinessDomain found = repository.
                findByName(businessDomain.getName());

        assertThat(found.getName()).isEqualTo(found.getName());
    }
}
