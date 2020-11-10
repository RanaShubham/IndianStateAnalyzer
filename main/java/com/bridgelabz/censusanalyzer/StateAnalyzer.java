package com.bridgelabz.censusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.bridgelabz.censusanalyzer.StateAnalyzerException.Exception_Error_Type;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateAnalyzer 
{
	public int loadIndianStateCensusCsv(String csvFilePath)
	{
		if(!csvFilePath.contains(".csv"))
			throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_FILE_TYPE, "Only csv files are supported");
		int recordCounter = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
		{
			String firstLineOfFile = Files.lines(Paths.get(csvFilePath)).findFirst().get();
			
			//If file header doesn't contain expected delimiter.
			if(!firstLineOfFile.contains(","))
				throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_DELIMETER, "Invalid delimeter");
			
			String [] fileHeaderArray = firstLineOfFile.trim().split(",");
			
			for (int i=0; i < fileHeaderArray.length; i++)
			{
				try {
					if(!fileHeaderArray[i].equals(IndianStateCensus.headerArray[i]))
						//If any header of POJO class and file is not same.
						throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				} catch (ArrayIndexOutOfBoundsException e) {
					//If all the headers of file are same as POJO's headers but file has extra headers.
					throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				}
			}
			
			CsvToBeanBuilder<IndianStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<IndianStateCensus>(reader);
			CsvToBean<IndianStateCensus> beanToCsv = csvToBeanBuilder.withType(IndianStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndianStateCensus> iterator = beanToCsv.iterator();
			while(iterator.hasNext())
			{
				++recordCounter;
				iterator.next();
			}	
		} catch (IOException e) {
			throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_PATH, "File path incorrect.");
		}
		return recordCounter;
	}
	
	public int loadIndianStateCodeCsv(String csvFilePath)
	{
		if(!csvFilePath.contains(".csv"))
			throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_FILE_TYPE, "Only csv files are supported");
		int recordCounter = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
		{
			String firstLineOfFile = Files.lines(Paths.get(csvFilePath)).findFirst().get();
			
			//If file header doesn't contain expected delimiter.
			if(!firstLineOfFile.contains(","))
				throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_DELIMETER, "Invalid delimeter");
			
			String [] fileHeaderArray = firstLineOfFile.trim().split(",");
			
			for (int i=0; i < fileHeaderArray.length; i++)
			{
				try {
					if(!fileHeaderArray[i].equals(IndianStateCode.headerArray[i]))
						//If any header of POJO class and file is not same.
						throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				} catch (ArrayIndexOutOfBoundsException e) {
					//If all the headers of file are same as POJO's headers but file has extra headers.
					throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				}
			}
			
			CsvToBeanBuilder<IndianStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<IndianStateCensus>(reader);
			CsvToBean<IndianStateCensus> beanToCsv = csvToBeanBuilder.withType(IndianStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndianStateCensus> iterator = beanToCsv.iterator();
			while(iterator.hasNext())
			{
				++recordCounter;
				iterator.next();
			}	
		} catch (IOException e) {
			throw new StateAnalyzerException(Exception_Error_Type.INCORRECT_PATH, "File path incorrect.");
		}
		return recordCounter;
	}
}
