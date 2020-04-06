package com.gwrocha.vancol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwrocha.vancol.models.Running;

@Repository
public interface RunningRepository extends JpaRepository<Running, Long> {

}
