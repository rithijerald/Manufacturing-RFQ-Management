package com.cognizant.rfq.supplierModule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.rfq.supplierModule.models.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
	
}
