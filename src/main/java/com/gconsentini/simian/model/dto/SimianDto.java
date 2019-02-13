package com.gconsentini.simian.model.dto;

import lombok.Data;

@Data
public class SimianDto {

    public SimianDto(){

    }

    public SimianDto(String[] dna){
        this.dna = dna;
    }

    private String[] dna = new String[0];

    public String toDnaSequence(){
        return String.join(", ", dna);
    }
}
