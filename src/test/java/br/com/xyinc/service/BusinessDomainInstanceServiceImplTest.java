package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainInstanceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by manuele on 19/10/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessDomainInstanceServiceImplTest {

    @Autowired
    private BusinessDomainInstanceService businessDomainInstanceService;

    @MockBean
    public BusinessDomainInstanceRepository repository;

    @Before
    public void setUp() {
        long id = 1L;

        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        businessDomain.setId(id);

        BusinessDomainInstance instance = new BusinessDomainInstance();
        instance.setBusinessDomain(businessDomain);
        instance.setId(id);

        given(repository.findById(id)).willReturn(instance);
    }

    @Test
    public void whenValidIdThenBusinessDomainInstanceShouldBeFound(){
        long id = 1L;
        BusinessDomainInstance found = businessDomainInstanceService.getBusinessDomainInstanceById(id);

        assertThat(found.getId()).isEqualTo(id);
    }
}
