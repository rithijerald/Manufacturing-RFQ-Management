package com.cts.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.model.RFQ;
import com.cts.RFQservice.RFQService;


@RestController

public class RFqController 
{
	
	
	private static final Logger log = LoggerFactory.getLogger(RFqController.class);
	@Autowired
    private RFQService  rfqService;
	@GetMapping("/helo") 
	public String helo() {
		System.out.println("helo");
		return "Succ";
	}
    @GetMapping("/getRFQOfPlant/{Plantid}")
    public RFQ getRFQOfPlant(@PathVariable Integer Plantid){
    	log.info("Inside getRFQOfPlant of RFqController");
    	Optional<RFQ> rfq=rfqService.findAll(Plantid);
    	return rfq.get();
    }
    
   @GetMapping("/getPotentialVendorsOfRFQ/{RFQId}")
   public ResponseEntity<Integer> getPotentialVendorsOfRFQ(@PathVariable Integer RFQId)  {
	   log.info("Inside getPotentialVendorsOFRFQ of RFQController");
	   Optional<RFQ> rfq = rfqService.findbyRFQId(RFQId);
	   if ( rfq !=null)
	   {
		   Integer partId = rfq.get().getPartId();
		   return new ResponseEntity<Integer>(partId, HttpStatus.OK);
	   }else
		    return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);

	
   }
		   
}