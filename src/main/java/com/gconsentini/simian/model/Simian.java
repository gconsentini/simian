package com.gconsentini.simian.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@Entity
public class Simian {

    @Id
    private Long id;

    @Transient
    private List<String> dna;

    @Column(name = "dna_sequence")
    private String dnaSequence;

    @Column
    private Boolean simian;

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
