package br.com.xyinc.service;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.repository.BusinessDomainInstanceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    private BusinessDomainInstance instance;
    private BusinessDomain businessDomain;

    @Before
    public void setUp() {
        long id = 1L;

        businessDomain = new BusinessDomain();
        businessDomain.setName("pencil");
        businessDomain.setId(id);

        instance = new BusinessDomainInstance();
        instance.setBusinessDomain(businessDomain);
        instance.setId(id);
    }

    @Test
    public void whenValidIdThenBusinessDomainInstanceShouldBeFound(){
        long id = 1L;

        given(repository.findById(id)).willReturn(instance);

        BusinessDomainInstance found = businessDomainInstanceService.getBusinessDomainInstanceById(id);

        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void whenValidBusinessModelThenAllInstancesShouldBeFound(){
        given(repository.findByBusinessDomain(businessDomain)).willReturn(Arrays.asList(instance));

        List<BusinessDomainInstance> found =
                businessDomainInstanceService.getAllInstancesByBusinessDomain(businessDomain);

        Assert.assertNotNull(found);
        Assert.assertEquals(1, found.size());
        assertThat(found.get(0).getBusinessDomain().getId()).isEqualTo(instance.getId());
    }

    @Test
    public void whenValidBusinessModelInstanceCreatedThenInstanceShouldBeCreated() {
        given(repository.save(instance)).willReturn(instance);

        BusinessDomainInstance saved =
                businessDomainInstanceService.createBusinessDomainInstance(instance);

        assertThat(saved, is(equalTo(instance)));
    }

    @Test
    public void whenvalidBusinessModelInstanceExistsThenShoulBeDeleted() {
        long id = 1L;
        doNothing().when(repository).delete(id);
        BusinessDomainInstanceRepository my =
                Mockito.mock(BusinessDomainInstanceRepository.class);

        businessDomainInstanceService.deleteBusinessDomainInstanceById(id);

        verify(repository, times(1)).delete(id);
    }

    @Test
    public void whenvalidBusinessModelInstanceExistsThenShoulBeUpdated() {
        given(repository.save(instance)).willReturn(instance);

        BusinessDomainInstanceRepository my =
                Mockito.mock(BusinessDomainInstanceRepository.class);

        businessDomainInstanceService.updateBusinessDomainInstance(instance);

        verify(repository, times(1)).save(instance);
    }
}
