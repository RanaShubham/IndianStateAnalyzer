package com.bridgelabz.censusanalyzertest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.censusanalyzer.CsvBuilderException;
import com.bridgelabz.censusanalyzer.StateAnalyzer;

public class StateAnalyzerTest 
{
	static final String INDIAN_STATE_CODE_FILE = "./src/main/resources/IndiaStateCode.csv";
	static final String INDIAN_CENSUS_CSV_FILE = "./src/main/resources/IndiaStateCensusData.csv";
	static final String INCORRECT_FILE_PATH = "./src/main/IndiaStateCensusData.csv";
	static final String INCORRECT_FILE_TYPE = "./src/main/resources/WrongType.txt";
	static final String INCORRECT_DELIMETER_CSV = "./src/main/resources/IncorrectDelimeter.csv";
	static final String INCORRECT_HEADER_CSV = "./src/main/resources/USCensusData.csv";
	
	static StateAnalyzer censusAnalyzer = new StateAnalyzer();
	@Test
	public void givenStateCesnusRecordFilePath_WhenLoaded_shouldReturnCount()
	{
		int count = censusAnalyzer.loadIndianStateCensusCsv(INDIAN_CENSUS_CSV_FILE);
		Assert.assertEquals(29, count);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCensusCSVFile_ifincorrect_shouldThrowsCensusAnalyzerException()
	{
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_FILE_PATH);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCensusCSVFile_butTypeIncorrect_shouldThrowCensusAnalyzerException()
	{
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_FILE_TYPE);
	}

	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCensusCSVFile_butDelimiterIncorrect_shouldThrowCensusAnalyzerException()
	{
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_DELIMETER_CSV);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCensusCSVFile_butHeaderIncorrect_shouldThrowCensusAnalyzerException()
	{
		censusAnalyzer.loadIndianStateCensusCsv(INCORRECT_HEADER_CSV);
	}
	
	static StateAnalyzer stateCodeAnalyzer = new StateAnalyzer();		
	@Test
	public void givenStateCesnusRecordFilePath_WhenLoaded_shouldReturncount()
	{
		int count = stateCodeAnalyzer.loadIndianStateCodeCsv(INDIAN_STATE_CODE_FILE);
		Assert.assertEquals(37, count);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCodeCSVFile_ifincorrect_shouldThrowsCensusAnalyzerException()
	{
		stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_FILE_PATH);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCodeCSVFile_butTypeIncorrect_shouldThrowCensusAnalyzerException()
	{
		stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_FILE_TYPE);
	}

	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCodeCSVFile_butDelimiterIncorrect_shouldThrowCensusAnalyzerException()
	{
		stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_DELIMETER_CSV);
	}
	
	@Test(expected = CsvBuilderException.class)
	public void GiventheStateCodeCSVFile_butHeaderIncorrect_shouldThrowCensusAnalyzerException()
	{
		stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_HEADER_CSV);
	}
}
