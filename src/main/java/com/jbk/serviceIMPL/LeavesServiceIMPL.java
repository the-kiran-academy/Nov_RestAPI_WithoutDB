package com.jbk.serviceIMPL;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jbk.model.Leaves;
import com.jbk.service.LeavesService;

@Service
public class LeavesServiceIMPL implements LeavesService {

	@Override
	public List<String> findLeavesDate(Leaves leaves) {
		List<String> list = new ArrayList<>();
		String startDate = leaves.getStartDate();
		String[] dmy = startDate.split("/");
		int day = Integer.parseInt(dmy[0]);
		int month = Integer.parseInt(dmy[1]);
		int year = Integer.parseInt(dmy[2]);

		Month m = Month.of(month);
		boolean isLeapYear = isLeapYear(year);

		for (int i = 0; i < m.length(isLeapYear); i++) {
			LocalDate localDate = LocalDate.of(year, month, day);
			boolean isWeekEnd = isWeekEnd(localDate);

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = localDate.format(dateTimeFormatter);

			boolean isCompanyHoliday = isCompanyHoliday(formattedDate, leaves.getCompanyHoliday());
			if (!isWeekEnd || !isCompanyHoliday) {
				list.add(formattedDate);
				if (list.size() == leaves.getNoOfLeaves()) {
					break;
				}
			}
			day = day+1;

		}

		return list;
	}

	private boolean isCompanyHoliday(String formattedDate, List<String> companyHoliday) {
		if (companyHoliday.contains(formattedDate)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isWeekEnd(LocalDate localDate) {
		String dayOfWeek = localDate.getDayOfWeek().toString();
		if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if (year % 400 == 0) {
			isLeapYear = true;
		} else if (year % 100 == 0) {
			isLeapYear = false;
		} else if (year % 4 == 0) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}
		return isLeapYear;
	}

}
