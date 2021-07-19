package com.cts.plant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.plant.model.PlantReorderDetails;

@Repository
public interface PlantReorderDetailsRepository extends JpaRepository<PlantReorderDetails, Integer> {

}
