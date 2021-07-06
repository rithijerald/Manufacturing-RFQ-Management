package com.cognizant.rfq.supplierModule.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.repository.SupplierRepo;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepo supplierRepo;
	
	public List<Supplier> allSuppliers(){
		return supplierRepo.findAll();
	}
	
	public Supplier getSupplier(int id) {
		return supplierRepo.findById(id).get();
	}
	
	public void addSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
	}
	
	public void editSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
	}
	
	public void updateFeedback(int id,int feedback) {
		Supplier mysupplier = supplierRepo.findById(id).get();
		mysupplier.setFeedback(feedback);
		supplierRepo.save(mysupplier);
	}
	

}
