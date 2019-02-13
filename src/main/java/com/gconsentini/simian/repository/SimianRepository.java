package com.gconsentini.simian.repository;

import com.gconsentini.simian.model.Simian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimianRepository extends JpaRepository<Simian, Long> {

    @Query(value = "SELECT * FROM Simian WHERE dna_sequence = ?1", nativeQuery = true)
    Simian findBySimian(String dnaSequence);

}
