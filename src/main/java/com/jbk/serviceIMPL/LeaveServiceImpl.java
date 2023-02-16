package com.jbk.serviceIMPL;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jbk.model.Leave;
import com.jbk.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService 
{
	@Override
	public List<String> findLeaveDates(Leave leave) 
	{
		List<String> list = new ArrayList<>();
		String startDate = leave.getStartDate();
		String[] startDMY = startDate.split("/");
		int startDay = Integer.parseInt(startDMY[0]);
		int startMonth = Integer.parseInt(startDMY[1]);
		int startYear = Integer.parseInt(startDMY[2]);
		Month startMonthOf = Month.of(startMonth);
		boolean isLeapYear = isLeapYear(startYear);
		
		for (int i = 0; i <= startMonthOf.length(isLeapYear); i++) 
		{
			LocalDate localDate = LocalDate.of(startYear, startMonth, startDay);
			boolean isWeekend = isWeekend(localDate);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = localDate.format(dateTimeFormatter);
			boolean isCompanyHoliday = isCompanyHoliday(formattedDate,leave.getCompanyHolidays());
			if(!isWeekend && !isCompanyHoliday)
			{
				list.add(formattedDate);
				
				if(list.size() == leave.getNoOfLeaves())
				{
					break;
				}
			}
			startDay = startDay + 1;
			if(startDay == startMonthOf.length(isLeapYear))
			{
				startMonth = startMonth + 1;
				startDay = 1;
			}
		}
		return list;
	}

	private boolean isCompanyHoliday(String formattedDate, List<String> companyHolidays) 
	{
		if(companyHolidays.contains(formattedDate))
		{
			return true;
		}
		else
		{
			 return false;
		}
	}

	private boolean isWeekend(LocalDate localDate) 
	{
		String dayOfWeek = localDate.getDayOfWeek().toString();
		if("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	private boolean isLeapYear(int year) 
	{	
		boolean isLeapYear = false;
		if(year % 400 == 0)
		{
			return !isLeapYear;
		}
		else if(year % 100 == 0)
		{
			return isLeapYear;
		}
		else if(year % 4 == 0)
		{
			return !isLeapYear;
		}
		else
		{
			return isLeapYear;
		}
	}	
}

