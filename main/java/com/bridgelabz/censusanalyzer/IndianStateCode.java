package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCode {

	public final static String [] headerArray= {"SrNo","State Name","TIN","StateCode"};

	@CsvBindByName(column = "SrNo")
	public String srNo;
	@CsvBindByName(column = "State Name")
	public long stateName;
	@CsvBindByName(column = "TIN")
	public long tin;
	@CsvBindByName(column = "StateCode")
	public long stateCode;

}
