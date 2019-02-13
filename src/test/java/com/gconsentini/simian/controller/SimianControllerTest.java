package com.gconsentini.simian.controller;

import com.gconsentini.simian.model.dto.SimianDto;
import com.gconsentini.simian.model.dto.StatsDto;
import com.gconsentini.simian.service.SimianService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SimianController.class, secure = false)
public class SimianControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SimianService simianService;

    StatsDto statsDto = new StatsDto(100L, 40L, 0.4);
    String jsonSimian = "{\"dna\": [\"ATGCGA\", \"CAGTGC\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"TCACTT\"]}";

    @Test
    public void testGetOkFromSimianRoute() throws Exception {
        Mockito.when(simianService.isSimian(Mockito.any())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/simian")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonSimian)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(response.getStatus());
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetForbiddenFromSimianRoute() throws Exception {
        Mockito.when(simianService.isSimian(Mockito.any())).thenReturn(false);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                post("/simian")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonSimian)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
    }

    @Test
    public void testGetStatsSimianRoute() throws Exception {
        Mockito.when(simianService.getStats()).thenReturn(statsDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                get("/stats");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals("{\"ratio\":0.4,\"count_human_dna\":100,\"count_simian_dna\":40}", response.getContentAsString());
    }


}