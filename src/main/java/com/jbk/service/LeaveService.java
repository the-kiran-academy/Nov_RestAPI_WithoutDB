package com.jbk.service;

import java.util.List;
import com.jbk.model.Leave;

public interface LeaveService 
{
	List<String> findLeaveDates(Leave leave);
}
