package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.service.PlantService;

@RestController
public class PlantController {
	@Autowired
	private PlantService plantService;
	

}
