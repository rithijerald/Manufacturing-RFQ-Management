package com.cts.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RFQRepo extends JpaRepository<RFQservice, Integer> {

}
