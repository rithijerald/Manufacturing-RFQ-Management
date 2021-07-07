package com.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Demand;
import com.model.Part;
import com.model.PlantReorderDetails;
import com.model.ReorderRules;
import com.repository.DemandRepository;
import com.repository.PartRepository;
import com.repository.PlantReorderDetailsRepository;
import com.repository.ReorderRulesRepository;


@Service
public class PlantService {
	
	private static final Logger log = LoggerFactory.getLogger(PlantService.class);
	
	@Autowired
	private PartRepository partRepository;

	@Autowired
	private PlantReorderDetailsRepository plantReorderDetailsRepository;
	
	@Autowired
	private ReorderRulesRepository reorderRulesRepository;
	
	@Autowired
	private DemandRepository demandRepository;
	
	public List<Part> findAll() {
		log.info("Inside findAll of PartService");
		return partRepository.findAll();
	}
	
	public Part viewStockInHand(Integer partId) {
		log.info("Inside viewStockInHand of service");
		return partRepository.viewStockInHand(partId);
	}
	
	public List<PlantReorderDetails> findAllPartsInReorder() {
		log.info("Inside findAllPartsInReorder of plant service");
		List<PlantReorderDetails> plantReorderDetailsTemporaryList = new ArrayList<>();
		List<PlantReorderDetails> plantReorderDetailsList = plantReorderDetailsRepository.findAll();
		
		for (PlantReorderDetails plantReorderDetails : plantReorderDetailsList) {
			if(plantReorderDetails != null && plantReorderDetails.getReorderStatus().equalsIgnoreCase("pending")) {
				plantReorderDetailsTemporaryList.add(plantReorderDetails);
			}
		}
		return plantReorderDetailsTemporaryList;
	}
	
	public ReorderRules findById(Integer partId) {
		log.info("Inside findById of PartService");
		return reorderRulesRepository.findByPartId(partId);
	}
	
	public void save(ReorderRules reorderRules) {
		log.info("Inside save of PartService");
		reorderRulesRepository.save(reorderRules);
	}
	
	public Optional<Demand> findByDemandId(Integer demandId) {
		log.info("Inside findByDemandId of PartService");
		return demandRepository.findAllById(demandId);
	}
}
