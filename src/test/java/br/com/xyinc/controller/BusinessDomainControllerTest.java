package br.com.xyinc.controller;

import br.com.xyinc.model.BusinessDomain;
import br.com.xyinc.model.BusinessDomainAtt;
import br.com.xyinc.repository.JsonUtil;
import br.com.xyinc.service.BusinessDomainService;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by manuele on 22/10/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BusinessDomainController.class)
public class BusinessDomainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusinessDomainService service;

    private long id;
    private BusinessDomain businessDomain;

    @Before
    public void setUp(){
        id = 1L;
        businessDomain = new BusinessDomain();
        businessDomain.setId(id);
        businessDomain.setName("product");
    }

    @Test
    public void givenBusinessModelWhenCreateThenReturnJsonObject() throws Exception
    {
        BusinessDomainAtt modeltt = new BusinessDomainAtt();
        modeltt.setName("name");
        modeltt.setType("String");
//        modeltt.setBusinessDomain(businessDomain);

        businessDomain.setBusinessDomainAtts(Arrays.asList(modeltt));

        byte[] createdJson = JsonUtil.toJson(businessDomain);

        given(service.createBusinessDomain(
                Matchers.any(BusinessDomain.class)))
                .willReturn(businessDomain);

        mvc.perform(MockMvcRequestBuilders.post("/businessdomain")
                .content(createdJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.attributes", hasSize(1)))
                .andExpect(jsonPath("$.attributes[0].name", is(modeltt.getName())))
                .andExpect(jsonPath("$.attributes[0].type", is(modeltt.getType())));
    }

    @Test
    public void givenIdWhenDeleteThenReturnOk() throws Exception
    {
        doNothing().when(service).deleteBusinessDomainById(id);

        mvc.perform(MockMvcRequestBuilders.delete(String.format("/businessdomain/%s", id))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
