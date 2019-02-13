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
    public void is_human(){
        String [] validDna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        String [] invalidDna = {"TTGAGA", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        Assert.assertFalse(DnaHelper.isSimian(validDna));
        Assert.assertFalse(DnaHelper.isSimian(invalidDna));
    }

    @Test
    public void is_invalid_dna(){
        String [] zeroDna= {};
        String [] zeroDnaQuotes= {""};
        String [] invalidDna = {"XXTAGY", "CTGAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCACTG"};
        String [] lessDna = {"XXTAGA", "CAGC", "TATTGT", "AGAGTG", "ACCTTA", "TCTG"};
        Assert.assertFalse(DnaHelper.isValidDna(zeroDna));
        Assert.assertFalse(DnaHelper.isValidDna(zeroDnaQuotes));
        Assert.assertFalse(DnaHelper.isValidDna(invalidDna));
        Assert.assertFalse(DnaHelper.isValidDna(lessDna));
    }

}
