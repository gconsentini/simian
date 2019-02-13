package com.gconsentini.simian.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Simian {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", name = "dna_sequence")
    private String dnaSequence;

    @Column
    private Boolean simian;

    public Simian(){
    }

    public Simian(Long id, String[] dnaSequence, Boolean simian){
        this.id = id;
        this.setDnaSequence(dnaSequence);
        this.simian = simian;
    }

    public void setDnaSequence(String[] dnaSequence) {
        this.dnaSequence = String.join(", ", dnaSequence);
    }

    public String getDnaSequence(){
        return this.dnaSequence;
    }

    public boolean isSimian(){
        return this.getSimian();
    }




}
