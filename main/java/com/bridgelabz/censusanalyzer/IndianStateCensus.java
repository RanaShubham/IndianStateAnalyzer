package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCensus 
{
	public static final String [] headerArray= {"State","Population","AreaInSqKm","DensityPerSqKm"};

	@CsvBindByName(column = "State")
	public String state;
	@CsvBindByName(column = "Population")
	public long population;
	@CsvBindByName(column = "AreaInSqKm")
	public long areaInSqKm;
	@CsvBindByName(column = "DensityPerSqKm")
	public long densityPerSqKm;
}
