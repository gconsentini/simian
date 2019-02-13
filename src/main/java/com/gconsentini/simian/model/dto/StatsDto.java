package com.gconsentini.simian.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatsDto {
    public StatsDto(){

    }

    public StatsDto(Long humanCount, Long simianCount, Double ratio){
        this.humanCount = humanCount;
        this.simianCount = simianCount;
        this.ratio = ratio;
    }

    @JsonProperty("count_human_dna")
    private Long humanCount;

    @JsonProperty("count_simian_dna")
    private Long simianCount;

    private Double ratio;

}
