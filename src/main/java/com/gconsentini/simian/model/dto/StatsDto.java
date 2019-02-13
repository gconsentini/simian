package com.gconsentini.simian.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatsDto {

    @JsonProperty("count_human_dna")
    private Long humanCount;

    @JsonProperty("count_simian_dna")
    private Long simianCount;

    private Double ratio;

}
