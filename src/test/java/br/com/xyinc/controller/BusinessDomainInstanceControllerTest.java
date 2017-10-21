package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainAtt;
import br.com.xyinc.model.BusinessDomainInstance;
import br.com.xyinc.model.BusinessDomainInstanceAtt;
import br.com.xyinc.service.BusinessDomainInstanceService;
import br.com.xyinc.service.BusinessDomainService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by manuele on 19/10/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BusinessDomainInstanceController.class)
public class BusinessDomainInstanceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusinessDomainInstanceService instanceService;

    @MockBean
    private BusinessDomainService service;

    @Autowired
    ObjectMapper objectMapper;

    private String businessModelName;
    private long id;
    private BusinessDomainInstance instance;
    private BusinessDomain businessDomain;

    @Before
    public void setUp(){
        id = 1L;
        businessModelName = "product";

        businessDomain = new BusinessDomain();
        businessDomain.setId(id);
        businessDomain.setName("pencil");

        instance = new BusinessDomainInstance();
        instance.setId(id);
        instance.setBusinessDomain(businessDomain);
    }

    @Test
    public void givenInstancesWhenGetInstancesThenReturnJsonArray()
            throws Exception
    {
        List<BusinessDomainInstance> instances = Arrays.asList(instance);

        given(service.getBusinessDomainByName(businessModelName)).willReturn(businessDomain);
        given(instanceService.getAllInstancesByBusinessDomain(businessDomain))
                .willReturn(instances);

        mvc.perform(MockMvcRequestBuilders.get(String.format("/%s", businessModelName))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is((int)instance.getId())));
    }

    @Test
    public void givenInstanceWhenGetInstanceThenReturnJsonObject()
            throws Exception
    {
        given(instanceService.getBusinessDomainInstanceById(id)).willReturn(instance);

        mvc.perform(MockMvcRequestBuilders.get(String.format("/%s/%s", businessModelName, instance.getId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int)instance.getId())));
    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

    @Test
    public void givenBusinessModelWhenCreateInstanceThenReturnJsonObject() throws Exception
    {
        BusinessDomainAtt modeltt = new BusinessDomainAtt();
        modeltt.setName("name");
        modeltt.setType("String");
        modeltt.setBusinessDomain(businessDomain);

        BusinessDomainInstanceAtt att = new BusinessDomainInstanceAtt();
        att.setAttValue("Maria");
        att.setBusinessDomainAtt(modeltt);

        BusinessDomainInstance created = new BusinessDomainInstance();
        created.setBusinessDomain(businessDomain);
        created.setId(id);
        created.setBusinessDomainInstanceAtts(Arrays.asList(att));

        byte[] createdJson = toJson(created);

        given(service.getBusinessDomainByName(businessModelName)).willReturn(businessDomain);
        given(instanceService.createBusinessDomainInstance(
                Matchers.any(BusinessDomainInstance.class)))
                .willReturn(created);

        mvc.perform(MockMvcRequestBuilders.post(String.format("/%s", businessModelName))
                    .content(createdJson)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", notNullValue()))
                    .andExpect(jsonPath("$.attributes", hasSize(1)))
                    .andExpect(jsonPath("$.attributes[0].businessDomainAtt.name", is(modeltt.getName())))
                    .andExpect(jsonPath("$.attributes[0].attValue", is(att.getAttValue())));
    }

    @Test
    public void givenIdWhenDeleteInstanceThenReturnOk() throws Exception
    {
        given(service.getBusinessDomainByName(businessModelName)).willReturn(businessDomain);
        doNothing().when(instanceService).deleteBusinessDomainInstanceById(id);

        mvc.perform(MockMvcRequestBuilders.delete(String.format("/%s/%s", businessModelName, id))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
