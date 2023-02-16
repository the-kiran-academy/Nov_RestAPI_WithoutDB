package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.model.Leave;
import com.jbk.service.LeaveService;

@RestController
public class LeaveController 
{
	@Autowired
	private LeaveService service;
	
	@PostMapping("/getLeaveDates")
	public List<String> findLeaveDates(@RequestBody Leave leave)
	{
		return service.findLeaveDates(leave);
	}
	
}
