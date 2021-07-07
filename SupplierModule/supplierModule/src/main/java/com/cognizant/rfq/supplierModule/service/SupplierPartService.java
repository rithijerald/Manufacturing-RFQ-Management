package com.cognizant.rfq.supplierModule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.SupplierPart;
import com.cognizant.rfq.supplierModule.repository.SupplierPartRepo;

@Service
public class SupplierPartService {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierPartService.class);

	@Autowired
	private SupplierPartRepo supplierPartRepo;
	
	public SupplierPart save(SupplierPart supplierPart) {
		log.info("Inside save of SupplierPart Service");
		return supplierPartRepo.save(supplierPart);
	}
	
	public SupplierPart findById(Integer partId) {
		log.info("Inside findById of SupplierPart Service");
		return supplierPartRepo.findById(partId).get();
	}
}
