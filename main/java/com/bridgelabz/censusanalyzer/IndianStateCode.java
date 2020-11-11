package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCode {

	public final static String [] headerArray= {"SrNo","State Name","TIN","StateCode"};

	@CsvBindByName(column = "SrNo")
	public String srNo;
	@CsvBindByName(column = "State Name")
	public String stateName;
	@CsvBindByName(column = "TIN")
	public int tin;
	@CsvBindByName(column = "StateCode")
	public String stateCode;
}
