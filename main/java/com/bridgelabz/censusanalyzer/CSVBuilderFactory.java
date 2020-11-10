package com.bridgelabz.censusanalyzer;

public class CSVBuilderFactory {

	public static ICsvBuilder createCsvBuilder() 
	{
		return new OpenCsvBuilder();
	}

}
