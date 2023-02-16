package com.jbk.model;

import java.util.List;

public class Leaves {

	private int noOfLeaves;
	private String startDate;
	private boolean isSaturdayHoliday;
	private boolean isSundayHoliday;
	private List<String> companyHoliday;

	public Leaves() {

	}

	public Leaves(int noOfLeaves, String startDate, boolean isSaturdayHoliday, boolean isSundayHoliday,
			List<String> companyHoliday) {
		super();
		this.noOfLeaves = noOfLeaves;
		this.startDate = startDate;
		this.isSaturdayHoliday = isSaturdayHoliday;
		this.isSundayHoliday = isSundayHoliday;
		this.companyHoliday = companyHoliday;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isSaturdayHoliday() {
		return isSaturdayHoliday;
	}

	public void setSaturdayHoliday(boolean isSaturdayHoliday) {
		this.isSaturdayHoliday = isSaturdayHoliday;
	}

	public boolean isSundayHoliday() {
		return isSundayHoliday;
	}

	public void setSundayHoliday(boolean isSundayHoliday) {
		this.isSundayHoliday = isSundayHoliday;
	}

	public List<String> getCompanyHoliday() {
		return companyHoliday;
	}

	public void setCompanyHoliday(List<String> companyHoliday) {
		this.companyHoliday = companyHoliday;
	}

	@Override
	public String toString() {
		return "Leaves [noOfLeaves=" + noOfLeaves + ", startDate=" + startDate + ", isSaturdayHoliday="
				+ isSaturdayHoliday + ", isSundayHoliday=" + isSundayHoliday + ", companyHoliday=" + companyHoliday
				+ "]";
	}

}
