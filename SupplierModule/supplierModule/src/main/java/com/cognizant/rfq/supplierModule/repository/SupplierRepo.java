package com.cognizant.rfq.supplierModule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.rfq.supplierModule.models.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
	
	@Query("SELECT s FROM Supplier s WHERE s.partId = :partId")
	List<Supplier> getSupplierOfPart(@Param("partId") int partId);

}
