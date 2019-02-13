package com.gconsentini.simian.service;

import com.gconsentini.simian.helper.DnaHelper;
import com.gconsentini.simian.model.Simian;
import com.gconsentini.simian.model.dto.SimianDto;
import com.gconsentini.simian.model.dto.StatsDto;
import com.gconsentini.simian.repository.SimianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimianService {

    @Autowired
    private SimianRepository simianRepository;

    public boolean isSimian(SimianDto simianDto){

        boolean isSimian;
        Simian simian = simianRepository.findBySimian(simianDto.toDnaSequence());
        if (simian != null){
            return simian.isSimian();
        }

        if (DnaHelper.isValidDna(simianDto.getDna())) {
            isSimian = DnaHelper.isSimian(simianDto.getDna());
        }else return false;


        simian = new Simian();
        simian.setDnaSequence(simianDto.getDna());
        simian.setSimian(isSimian);
        simianRepository.save(simian);

        return isSimian;
    }

    public StatsDto getStats(){
        StatsDto statsDto = new StatsDto();
        List<Simian> simianList = simianRepository.findAll();
        long humans = simianList.stream()
                .filter(simian -> !simian.isSimian())
                .count();

        long simians = simianList.stream()
                .filter(Simian::isSimian)
                .count();

        statsDto.setHumanCount(humans);
        statsDto.setSimianCount(simians);
        if(humans != 0) statsDto.setRatio((double)simians/(double)humans);
        else statsDto.setRatio(0.0);

        return statsDto;

    }


}
