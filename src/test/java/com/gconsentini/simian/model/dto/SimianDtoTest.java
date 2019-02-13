package com.gconsentini.simian.model.dto;

import org.junit.Assert;
import org.junit.Test;

public class SimianDtoTest {

    @Test
    public void testSimianDto(){
        SimianDto simianDto = new SimianDto();
        simianDto.setDna(new String[]{"DNA", "TES", "TES"});
        Assert.assertNotNull(simianDto);
        Assert.assertEquals("DNA", simianDto.getDna()[0]);
        Assert.assertEquals("TES", simianDto.getDna()[1]);
        Assert.assertEquals("TES", simianDto.getDna()[2]);
    }

    @Test
    public void testGetDnaSequence(){
        SimianDto simianDto = new SimianDto(new String[]{"DNA", "TES", "TES"});
        Assert.assertNotNull(simianDto);
        Assert.assertEquals("DNA, TES, TES", simianDto.getDnaSequence());
    }

}