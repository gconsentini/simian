package com.gconsentini.simian.repository;

import com.gconsentini.simian.model.Simian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimianRepository extends JpaRepository<Simian, Long> {

    Simian findBySimian(String dnaSequence);

}
