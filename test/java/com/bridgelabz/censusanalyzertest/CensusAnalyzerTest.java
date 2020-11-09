package com.bridgelabz.censusanalyzertest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.censusanalyzer.CensusAnalyzerExcepition;
import com.bridgelabz.censusanalyzer.StateCensusAnalyzer;

public class CensusAnalyzerTest 
{
	static final String INDIAN_CENSUS_CSV_FILE = "./src/main/resources/IndiaStateCensusData.csv";
	static final String INCORRECT_FILE_PATH = "./src/main/IndiaStateCensusData.csv";
	static final String INCORRECT_FILE_TYPE = "./src/main/resources/WrongType.txt";
	static final String INCORRECT_DELIMETER_CSV = "./src/main/resources/IncorrectDelimeter.csv";
	static final String INCORRECT_HEADER_CSV = "./src/main/resources/USCensusData.csv";
	
	@Test
	public void givenStateCesnusRecordFilePath_WhenLoaded_shouldReturncount()
	{
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer();
		int count = censusAnalyzer.loadIndianStateCensusCsv(INDIAN_CENSUS_CSV_FILE);
		Assert.assertEquals(29, count);
	}
	
	@Test(expected = CensusAnalyzerExcepition.class)
	public void GiventheStateCensusCSVFile_ifincorrect_shouldThrowsCensusAnalyzerException()
	{
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer();
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_FILE_PATH);
	}
	
	@Test(expected = CensusAnalyzerExcepition.class)
	public void GiventheStateCensusCSVFile_butTypeIncorrect_shouldThrowCensusAnalyzerException()
	{
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer();
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_FILE_TYPE);
	}

	@Test(expected = CensusAnalyzerExcepition.class)
	public void GiventheStateCensusCSVFile_butDelimiterIncorrect_shouldThrowCensusAnalyzerException()
	{
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer();
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_DELIMETER_CSV);
	}
	
	@Test(expected = CensusAnalyzerExcepition.class)
	public void GiventheStateCensusCSVFile_butHeaderIncorrect_shouldThrowCensusAnalyzerException()
	{
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer();
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_HEADER_CSV);
	}
}
