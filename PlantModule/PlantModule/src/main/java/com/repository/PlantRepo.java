package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.rfq.supplierModule.models.Supplier;

@Repository
public interface PlantRepo extends JpaRepository<Parts, Integer> {

}
