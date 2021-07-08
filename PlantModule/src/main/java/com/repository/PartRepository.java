package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.Param;
import com.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
	@Query("SELECT p FROM Part p WHERE p.partId = :partId")
	public Part viewStockInHand(@Param("partId") Integer partId);

}
