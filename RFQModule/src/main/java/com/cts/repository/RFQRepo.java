package com.cts.repository;

import org.springframework.stereotype.Repository;
import com.cts.model.RFQ;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RFQRepo extends JpaRepository<RFQ,Integer> {
	
	

}
