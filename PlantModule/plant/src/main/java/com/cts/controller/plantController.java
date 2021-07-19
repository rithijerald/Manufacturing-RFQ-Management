package com.cts.plant.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.plant.model.Demand;
import com.cts.plant.model.Part;
import com.cts.plant.model.PlantReorderDetails;
import com.cts.plant.model.ReorderRules;
import com.cts.plant.service.PlantService;

@RestController
public class plantController {

	

	private static final Logger log = LoggerFactory.getLogger(plantController.class);

	@Autowired
	private PlantService plantService;
	
	@GetMapping("/viewPartsReOrder")
	public List<PlantReorderDetails> viewPartsReorder() {
		log.info("Inside ViewPartsReorder of PartController");
		return plantService.findAllPartsInReorder();
	}

	@GetMapping("/viewStockInHand/{id}")
	public ResponseEntity<Part> viewStockInHand(@PathVariable("id") Integer partId) {
		log.info("Inside viewStockInHand of PartController");
		try {
			Part part = plantService.viewStockInHand(partId);
			return new ResponseEntity<Part>(part, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Part>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updateMinMaxQuantity")
	public ResponseEntity<String> updateMinMaxQuantities(@RequestBody ReorderRules reorderRules) {
		log.info("Inside updateMinMaxQuantities of PartController");
		try {
			ReorderRules reorderRulesTemplate = plantService.findById(reorderRules.getPartId());
			if (reorderRulesTemplate != null) {
				Optional<Demand> demand = plantService.findByDemandId(reorderRulesTemplate.getDemandId());
				Integer minQuantity = reorderRules.getMinQuantity();
				Integer maxQuantity = reorderRules.getMaxQuantity();
				if (maxQuantity < (demand.get().getDemandCount() * 20) / 100)
					reorderRulesTemplate.setMaxQuantity(reorderRules.getMaxQuantity());
				else
					return new ResponseEntity<String>("Maximum", HttpStatus.OK);

				if (minQuantity > (maxQuantity * 30) / 100 && minQuantity < (maxQuantity * 50) / 100)
					reorderRulesTemplate.setMinQuantity(reorderRules.getMinQuantity());
				else
					return new ResponseEntity<String>("Minimum", HttpStatus.OK);

				reorderRulesTemplate.setReorderFrequency(reorderRules.getMaxQuantity() - reorderRules.getMinQuantity());
				plantService.save(reorderRulesTemplate);
				return new ResponseEntity<String>("Updated", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(
						"PartId not found. Please provide valid partId to update min and max quantities",
						HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(
					"PartId not found. Please provide valid partId to update min and max quantities",
					HttpStatus.NOT_FOUND);
		}
	}

}
