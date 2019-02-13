package com.gconsentini.simian.model.dto;

import lombok.Data;

@Data
public class SimianDto {

    public SimianDto(){

    }

    public SimianDto(String[] dna){
        this.dna = dna;
    }

    private String[] dna;

    public String toDnaSequence(){
        return String.join(", ", dna);
    }
}
