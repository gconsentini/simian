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
        String [] validDna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        String [] invalidDna = {"TTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        Assert.assertFalse(DnaHelper.isSimian(validDna));
        Assert.assertFalse(DnaHelper.isSimian(invalidDna));
    }

    @Test
    public void is_invalid_dna(){
        String [] validDna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        String [] invalidDna = {"XXTAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        String [] lessDna = {"XXTAGA", "CAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCTG"};
        Assert.assertTrue(DnaHelper.isValidDna(validDna));
        Assert.assertFalse(DnaHelper.isValidDna(invalidDna));
        Assert.assertFalse(DnaHelper.isValidDna(lessDna));
    }

}
