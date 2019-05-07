package com.nuestar.neustarcatserv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuestar.neustarcatserv.constants.AppConstants;
import com.nuestar.neustarcatserv.model.ProcessedResult;
import com.nuestar.neustarcatserv.model.Product;
import com.nuestar.neustarcatserv.service.ProcessResourceService;

@RestController
@RequestMapping("/process")
public class ProcessResourceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessResourceImpl.class);
	
	@Autowired
	ProcessResourceService service;
	
	@RequestMapping(method = RequestMethod.POST, produces=AppConstants.APPLJSON,
			consumes = AppConstants.APPLJSON)
	public ProcessedResult process(@RequestBody List<Product> products){
		logger.info("processing products", products);
		ProcessedResult result = service.process(products);
		logger.info("Processed Result", result);
		return result;
	}
}
