package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainInstanceRepository;
import br.com.xyinc.repository.BusinessDomainRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by manuele on 22/10/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessDomainServiceImplTest {

    @Autowired
    private BusinessDomainService businessDomainService;

    @MockBean
    public BusinessDomainRepository repository;

    private BusinessDomain businessDomain;

    @Before
    public void setUp() {
        long id = 1L;

        businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        businessDomain.setId(id);
    }

    @Test
    public void whenValidBusinessModelCreatedThenModelShouldBeCreated() {
        given(repository.save(businessDomain)).willReturn(businessDomain);

        BusinessDomain saved =
                businessDomainService.createBusinessDomain(businessDomain);

        assertThat(saved, is(equalTo(businessDomain)));
    }

    @Test
    public void whenvalidBusinessModelInstanceExistsThenShoulBeDeleted() {
        long id = 1L;
        doNothing().when(repository).delete(id);
        BusinessDomainInstanceRepository my =
                Mockito.mock(BusinessDomainInstanceRepository.class);

        businessDomainService.deleteBusinessDomainById(id);

        verify(repository, times(1)).delete(id);
    }
}
