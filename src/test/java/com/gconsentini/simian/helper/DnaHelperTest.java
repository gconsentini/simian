package com.gconsentini.simian.helper;

import org.junit.Assert;
import org.junit.Test;

public class DnaHelperTest {

    @Test
    public void is_valid_simian(){
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        Assert.assertTrue(DnaHelper.isSimian(dna));
    }

    @Test
    public void is_invalid_simian(){
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        Assert.assertFalse(DnaHelper.isSimian(dna));
    }

}
