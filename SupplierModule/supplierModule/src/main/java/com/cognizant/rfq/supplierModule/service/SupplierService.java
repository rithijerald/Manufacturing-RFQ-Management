package com.cognizant.rfq.supplierModule.service;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.models.SupplierPart;
import com.cognizant.rfq.supplierModule.repository.SupplierRepo;

@Service
public class SupplierService {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierService.class);
	
	@Autowired
	private SupplierRepo supplierRepo;
	
	@Autowired
	private SupplierPartService supplierPartService;
	
	public List<Supplier> getAllSuppliers(){
		log.info("Inside getAllSuppliers of SUpplier Service");
		return supplierRepo.findAll();
	}
	
	public List<Supplier> getSupplierOfPart(int partId) {
		log.info("Inside getSupplierOfPart of Supplier Service");
		List<SupplierPart> supplierPartList = supplierPartService.findAll();
		List<Supplier> supplierList = new ArrayList<Supplier>();
		for(SupplierPart supplierpart : supplierPartList) {
			int id = supplierpart.getPartId();
			if(partId==id) {
				int supplierId = supplierpart.getSupplierId();
				Supplier supplier = supplierRepo.getOne(supplierId);
				supplierList.add(supplier);
			}
		}
		return supplierList;
	}
	
	public Supplier addSupplier(Supplier supplier) {
		log.info("Inside addSupplier of Supplier Service");
		return supplierRepo.save(supplier);
	}
	
	public Supplier editSupplier(Supplier supplier) {
		log.info("Inside editSupplier of Supplier Service");
		Supplier editSupplier = supplierRepo.getOne(supplier.getSupplierId());
		editSupplier.setName(supplier.getName());
		editSupplier.setEmail(supplier.getEmail());
		editSupplier.setPhone(supplier.getPhone());
		editSupplier.setLocation(supplier.getLocation());
		editSupplier.setFeedback(supplier.getFeedback());
		return supplierRepo.save(editSupplier);
	}
	
	public void updateFeedback(Supplier supplier) {
		log.info("Inside update feedback of supplier service");
		Supplier updateSupplier = supplierRepo.getOne(supplier.getSupplierId());
		updateSupplier.setFeedback(supplier.getFeedback());
		supplierRepo.save(updateSupplier);
	}
	
}
