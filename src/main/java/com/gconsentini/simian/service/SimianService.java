package com.gconsentini.simian.service;

import com.gconsentini.simian.helper.DnaHelper;
import com.gconsentini.simian.model.dto.SimianDto;
import org.springframework.stereotype.Service;

@Service
public class SimianService {


    public boolean isSimian(SimianDto simianDto){
        if (DnaHelper.isValidDna(simianDto.getDna())) {
            return DnaHelper.isSimian(simianDto.getDna());
        }
        return false;
    }


}
