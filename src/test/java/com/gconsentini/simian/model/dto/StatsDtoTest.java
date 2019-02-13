package com.gconsentini.simian.model.dto;

import org.junit.Assert;
import org.junit.Test;

public class StatsDtoTest {

    @Test
    public void testStatsDto(){
        StatsDto statDto = new StatsDto();
        statDto.setRatio(0.0);
        statDto.setSimianCount(1L);
        statDto.setHumanCount(1L);

        Assert.assertNotNull(statDto);

        Assert.assertEquals(new Double(0.0), statDto.getRatio());
        Assert.assertEquals(new Long(1L), statDto.getHumanCount());
        Assert.assertEquals(new Long(1L), statDto.getSimianCount());
    }

}