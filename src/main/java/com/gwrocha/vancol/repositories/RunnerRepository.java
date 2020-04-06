package com.gwrocha.vancol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwrocha.vancol.models.Runner;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {

}
