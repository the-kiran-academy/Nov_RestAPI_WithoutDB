package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Leaves;
import com.jbk.service.LeavesService;

@RestController
public class LeavesController {
	
	@Autowired
	private LeavesService service;
	
	@PostMapping(value="/find-leaves")
	public List<String> findLeavesDate(@RequestBody Leaves leaves){
		List<String> leavesDate = service.findLeavesDate(leaves);
		return leavesDate;
	}

}
