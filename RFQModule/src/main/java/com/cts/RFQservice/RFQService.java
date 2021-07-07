package com.cts.RFQservice;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.controller.logger;
import com.cts.model.RFQ;
import com.cts.repository.RFQRepo;

@Service
public class RFQService {
	
	
	private static final logger log = (logger) LoggerFactory.getLogger(RFQService.class);
	@Autowired
	private RFQRepo rfqRepository;
	
	public List<RFQ> findAll()
	{
		((Logger) log).info("Inside findALL of RFQServices");
		return rfqRepository.findAll();
	}
 public Optional<RFQ> findbyRFQId(Integer RFQid){
		((Logger) log).info("Inside +indByRFQId of RFQService");
		return rfqRepository.findById(RFQid);
		}
	}
