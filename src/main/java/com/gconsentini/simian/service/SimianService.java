package com.gconsentini.simian.service;

import com.gconsentini.simian.helper.DnaHelper;
import org.springframework.stereotype.Service;

@Service
public class SimianService {


    public boolean isSimian(String[] dna){
        if (DnaHelper.isValidDna(dna)) {
            return DnaHelper.isSimian(dna);
        }
        return false;
    }


}
