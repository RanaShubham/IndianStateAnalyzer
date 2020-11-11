package com.bridgelabz.censusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.bridgelabz.censusanalyzer.CsvBuilderException.Exception_Error_Type;
import com.bridgelabz.censusanalyzer.CsvBuilderException;

public class StateAnalyzer 
{
	/**
	 * Loads IndianStateCensus.csv file.
	 * @param csvFilePath Location of the file.
	 * @return Number of lines in file.
	 * @throws StateAnalyzerException When file file type is incorrect.
	 * @throws StateAnalyzerException When POJO class and file don't have matching headers.
	 * @throws StateAnalyzerException When file is not found at the given path.
	 * @throws StateAnalyzerException When file doesn't have expected delimiters in the headers.
	 */
	public int loadIndianStateCensusCsv(String csvFilePath)
	{
		if(!csvFilePath.contains(".csv"))
			throw new CsvBuilderException(Exception_Error_Type.INCORRECT_FILE_TYPE, "Only csv files are supported");
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
		{
			String firstLineOfFile = Files.lines(Paths.get(csvFilePath)).findFirst().get();
			
			//If file header doesn't contain expected delimiter.
			if(!firstLineOfFile.contains(","))
				throw new CsvBuilderException(Exception_Error_Type.INCORRECT_DELIMETER, "Invalid delimeter");
			
			String [] fileHeaderArray = firstLineOfFile.trim().split(",");
			
			for (int i=0; i<fileHeaderArray.length; i++)
			{
				try {
					if(!fileHeaderArray[i].equals(IndianStateCensus.headerArray[i]))
						//If any header of POJO class and file is not same.
						throw new CsvBuilderException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				} catch (ArrayIndexOutOfBoundsException e) {
					//If all the headers of file are more or headers of POJO are more.
					throw new CsvBuilderException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				}
			}
			ICsvBuilder<?> builder = CSVBuilderFactory.createCsvBuilder();
			Iterator<IndianStateCensus> iterator = builder.getCsvIterator(reader, IndianStateCensus.class);
			Iterable<IndianStateCensus> iterable = () -> iterator;
			int recordCounter = (int) StreamSupport.stream(iterable.spliterator(), false).count();
			return recordCounter;
		} catch (IOException e) {
			throw new CsvBuilderException(Exception_Error_Type.INCORRECT_PATH, "File path incorrect.");
		}
	}
	
	
	/**
	 * Loads IndianStateCode.csv file.
	 * @param csvFilePath file location.
	 * @return number of lines in that file.
	 * @throws StateAnalyzerException When file file type is incorrect.
	 * @throws StateAnalyzerException When POJO class and file don't have matching headers.
	 * @throws StateAnalyzerException When file is not found at the given path.
	 * @throws StateAnalyzerException When file doesn't have expected delimiters in the headers.
	 */
	public int loadIndianStateCodeCsv(String csvFilePath)
	{
		//If file type is correct.
		if(!csvFilePath.contains(".csv"))
			throw new CsvBuilderException(Exception_Error_Type.INCORRECT_FILE_TYPE, "Only csv files are supported");
		
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
		{
			String firstLineOfFile = Files.lines(Paths.get(csvFilePath)).findFirst().get();
			
			//If file header doesn't contain expected delimiter.
			if(!firstLineOfFile.contains(","))
				throw new CsvBuilderException(Exception_Error_Type.INCORRECT_DELIMETER, "Invalid delimeter");
			
			String [] fileHeaderArray = firstLineOfFile.trim().split(",");
			
			for (int i=0; i < fileHeaderArray.length; i++)
			{
				try {
					if(!fileHeaderArray[i].equals(IndianStateCode.headerArray[i]))
						//If any header of POJO class and file is not same.
						throw new CsvBuilderException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				} catch (ArrayIndexOutOfBoundsException e) {
					//If all the headers of file are more or headers of POJO are more.
					throw new CsvBuilderException(Exception_Error_Type.INCORRECT_HEADER, "Wrong file header.");
				}
			}
			ICsvBuilder<?> builder = CSVBuilderFactory.createCsvBuilder();
			Iterator<IndianStateCode> iterator = builder.getCsvIterator(reader, IndianStateCode.class);
			Iterable<IndianStateCode> iterable = () -> iterator;
			int recordCounter = (int) StreamSupport.stream(iterable.spliterator(), false).count();
			return recordCounter;
		} catch (IOException e) {
			throw new CsvBuilderException(Exception_Error_Type.INCORRECT_PATH, "File path incorrect.");
		}
	}
}
