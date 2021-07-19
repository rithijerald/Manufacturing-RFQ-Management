package com.cts.plant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.plant.model.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer> {

}
