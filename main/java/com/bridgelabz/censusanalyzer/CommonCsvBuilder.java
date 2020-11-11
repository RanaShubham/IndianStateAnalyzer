package com.bridgelabz.censusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class CommonCsvBuilder<E> implements ICsvBuilder<E>
{

	@Override
	public Iterator getCsvIterator(Reader reader, Class pojo) throws CsvBuilderException 
	{
		try(CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) 
		{
			List list = csvParser.getRecords();
			return list.iterator();
		} catch (IOException e) {
			return null;
		}
	}
	
}
