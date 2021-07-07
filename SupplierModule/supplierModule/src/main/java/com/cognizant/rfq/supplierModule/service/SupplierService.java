package com.cognizant.rfq.supplierModule.service;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.repository.SupplierRepo;

@Service
public class SupplierService {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierService.class);
	
	@Autowired
	private SupplierRepo supplierRepo;
	
	public List<Supplier> getSupplierOfPart(int partId) {
		log.info("Inside getSupplierOfPart of Supplier Service");
		return supplierRepo.getSupplierOfPart(partId);
	}
	
	public Supplier findById(Integer supplierId) {
		log.info("Inside findById of Supplier Service");
		return supplierRepo.findById(supplierId).get();
	}
	
	public Supplier save(Supplier supplier) {
		log.info("Inside save of Supplier Service");
		return supplierRepo.save(supplier);
	}
	
}
