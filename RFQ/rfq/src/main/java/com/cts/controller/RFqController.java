package com.cts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vendors")
public class RFqController {
    @Autowired

    
    
    @GetMapping(path = "/getRFQOfPlant/{Plantid}")
    public ResponseEntity<Object> getProductById(@PathVariable("Plantid") int Plantid){
    
}
    
    

    	
    }
    
    
    
    
	
	
	
	
	 
	
	
	
	
	
}
