package com.bridgelabz.censusanalyzertest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.censusanalyzer.StateAnalyzer;
import com.bridgelabz.censusanalyzer.StateAnalyzerException;

public class IndianStateCodeTest 
{
		static final String INDIAN_STATE_CODE_FILE = "./src/main/resources/IndiaStateCode.csv";
		static final String INCORRECT_FILE_PATH = "./src/main/IndiaStateCensusData.csv";
		static final String INCORRECT_FILE_TYPE = "./src/main/resources/WrongType.txt";
		static final String INCORRECT_DELIMETER_CSV = "./src/main/resources/IncorrectDelimeter.csv";
		static final String INCORRECT_HEADER_CSV = "./src/main/resources/USCensusData.csv";
		
		static StateAnalyzer stateCodeAnalyzer = new StateAnalyzer();		
		@Test
		public void givenStateCesnusRecordFilePath_WhenLoaded_shouldReturncount()
		{
			int count = stateCodeAnalyzer.loadIndianStateCodeCsv(INDIAN_STATE_CODE_FILE);
			Assert.assertEquals(37, count);
		}
		
		@Test(expected = StateAnalyzerException.class)
		public void GiventheStateCensusCSVFile_ifincorrect_shouldThrowsCensusAnalyzerException()
		{
			stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_FILE_PATH);
		}
		
		@Test(expected = StateAnalyzerException.class)
		public void GiventheStateCensusCSVFile_butTypeIncorrect_shouldThrowCensusAnalyzerException()
		{
			stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_FILE_TYPE);
		}

		@Test(expected = StateAnalyzerException.class)
		public void GiventheStateCensusCSVFile_butDelimiterIncorrect_shouldThrowCensusAnalyzerException()
		{
			stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_DELIMETER_CSV);
		}
		
		@Test(expected = StateAnalyzerException.class)
		public void GiventheStateCensusCSVFile_butHeaderIncorrect_shouldThrowCensusAnalyzerException()
		{
			stateCodeAnalyzer.loadIndianStateCodeCsv(INCORRECT_HEADER_CSV);
		}
}
