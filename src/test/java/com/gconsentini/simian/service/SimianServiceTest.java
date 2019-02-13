package com.gconsentini.simian.service;

import com.gconsentini.simian.model.Simian;
import com.gconsentini.simian.model.dto.SimianDto;
import com.gconsentini.simian.model.dto.StatsDto;
import com.gconsentini.simian.repository.SimianRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimianServiceTest {


    @Autowired
    private SimianService simianService;

    @MockBean
    private SimianRepository simianRepository;

    SimianDto simianDto = new SimianDto(new String[]{"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"});
    SimianDto simianDtoExist = new SimianDto(new String[]{"CTGAAA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"});
    SimianDto humanDto = new SimianDto(new String[]{"CTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"});
    SimianDto notValidDto = new SimianDto(new String[]{"CTGAGX", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"});
    SimianDto notValidDto2 = new SimianDto(new String[]{"CTGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"});

    StatsDto statsDto = new StatsDto(100L, 40L, 0.4);
    String jsonSimian = "{\"dna\": [\"ATGCGA\", \"CAGTGC\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"TCACTT\"]}";

    @Before
    public void setUp(){
        Mockito.when(simianRepository.findBySimian(simianDto.getDnaSequence())).thenReturn(null);
        Mockito.when(simianRepository.findBySimian(humanDto.getDnaSequence())).thenReturn(null);
        Mockito.when(simianRepository.findBySimian(simianDtoExist.getDnaSequence())).thenReturn(new Simian(1L, new String[0], true));
        Mockito.when(simianRepository.findBySimian(notValidDto.getDnaSequence())).thenReturn(null);
        Mockito.when(simianRepository.findBySimian(notValidDto2.getDnaSequence())).thenReturn(null);
        Mockito.when(simianRepository.findAll()).thenReturn(Collections.singletonList((new Simian(1L, new String[0], true))));
    }

    @Test
    public void testIsSimian() {
        Assert.assertTrue(simianService.isSimian(simianDto));
        Assert.assertFalse(simianService.isSimian(humanDto));
        Assert.assertTrue(simianService.isSimian(simianDtoExist));
        Assert.assertFalse(simianService.isSimian(notValidDto));
        Assert.assertFalse(simianService.isSimian(notValidDto2));

    }

    @Test
    public void testGetStats() {
        StatsDto statsDto = simianService.getStats();
        Assert.assertEquals(new Long(1L),statsDto.getSimianCount());
        Assert.assertEquals(new Long(0L),statsDto.getHumanCount());
        Assert.assertEquals(new Double(0.0),statsDto.getRatio());
    }

}