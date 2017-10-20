package br.com.xyinc.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by manuele on 19/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusinessDomainInstanceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void defaultRequest() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(MockMvcResultMatchers.status().is(200));

        mvc.perform(MockMvcRequestBuilders.get("/product/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void getAllBusinessDomainInstance() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/product")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        equalTo("[{\"id\":1,\"attributes\":[{\"att\":\"name : sabonete\"}]}]")));
    }

    @Test
    public void getProductById() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/product/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        equalTo("{\"id\":1,\"attributes\":[{\"att\":\"name : sabonete\"}]}")));
    }

    @Test
    public void createProduct() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post("/product")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/product/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        equalTo("{\"id\":2,\"attributes\":[]}")));
    }

    @Test
    public void deleteProduct() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post("/product")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.delete("/product/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
