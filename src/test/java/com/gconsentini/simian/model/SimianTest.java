package com.gconsentini.simian.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class SimianTest {

    @Test
    public void createNewSimian(){
        Simian simian= new Simian();
        simian.setId(1L);
        simian.setDnaSequence(new String[0]);
        simian.setSimian(false);

        Assert.assertNotNull(simian.getId());
        Assert.assertEquals("", simian.getDnaSequence());
        Assert.assertFalse(simian.isSimian());
    }

}