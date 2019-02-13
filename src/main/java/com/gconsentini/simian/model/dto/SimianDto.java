package com.gconsentini.simian.model.dto;

import lombok.Data;

@Data
public class SimianDto {
    private String[] dna;

    public String getDnaSequence(){
        return String.join(", ", dna);
    }
}
