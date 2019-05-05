package com.nuestar.neustarcatserv.controller;

import java.util.List;

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
	
	@Autowired
	ProcessResourceService service;
	
	@RequestMapping(method = RequestMethod.POST, produces=AppConstants.APPLJSON,
			consumes = AppConstants.APPLJSON)
	public ProcessedResult process(@RequestBody List<Product> products){
				
		return service.process(products);
	}
}
