package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.repository.SupplierRepo;

@Service
public class PlantService {
	@Autowired
	
	private PlantRepo plantRepo;
	
	public List<Parts> allParts(){
		return plantRepo.findAll();
	}
	


}
