package com.jbk.model;

import java.util.List;

public class Leave 
{
		int noOfLeaves;
		String startDate;
		boolean isSaturdayHoliday;
		boolean isSundayHoliday;
		List<String> companyHolidays;
		
		public Leave() 
		{
			super();
		}

		public Leave(int noOfLeaves, String startDate,String endDate, boolean isSaturdayHoliday, boolean isSundayHoliday,
				List<String> companyHolidays) 
		{
			super();
			this.noOfLeaves = noOfLeaves;
			this.startDate = startDate;
			this.isSaturdayHoliday = isSaturdayHoliday;
			this.isSundayHoliday = isSundayHoliday;
			this.companyHolidays = companyHolidays;
		}

		public int getNoOfLeaves() 
		{
			return noOfLeaves;
		}

		public void setNoOfLeaves(int noOfLeaves) 
		{
			this.noOfLeaves = noOfLeaves;
		}

		public String getStartDate()
		{
			return startDate;
		}

		public void setStartDate(String startDate) 
		{
			this.startDate = startDate;
		}

		public boolean isSaturdayHoliday() 
		{
			return isSaturdayHoliday;
		}

		public void setSaturdayHoliday(boolean isSaturdayHoliday)
		{
			this.isSaturdayHoliday = isSaturdayHoliday;
		}

		public boolean isSundayHoliday() 
		{
			return isSundayHoliday;
		}

		public void setSundayHoliday(boolean isSundayHoliday) 
		{
			this.isSundayHoliday = isSundayHoliday;
		}

		public List<String> getCompanyHolidays() 
		{
			return companyHolidays;
		}

		public void setCompanyHolidays(List<String> companyHolidays) 
		{
			this.companyHolidays = companyHolidays;
		}

		@Override
		public String toString() 
		{
			return "Leave [noOfLeaves=" + noOfLeaves + ", startDate=" + startDate +", isSaturdayHoliday="
					+ isSaturdayHoliday + ", isSundayHoliday=" + isSundayHoliday + ", companyHolidays=" + companyHolidays
					+ "]";
		}
		
}
