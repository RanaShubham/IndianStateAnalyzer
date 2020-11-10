package com.bridgelabz.censusanalyzer;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvBuilder 
{
	
	/**
	 * @param <E>
	 * @param Class pojoClass
	 * @param Reader reader
	 * @return Iterator to iterate over csvToBean object.
	 * @throws StateAnalyzerException
	 */
	public <E> Iterator<E> getCsvIterator(Reader reader, Class<E> pojoClass) throws StateAnalyzerException
	{	
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
		CsvToBean<E> csvToBean = csvToBeanBuilder.withType(pojoClass)
								.withIgnoreLeadingWhiteSpace(true).withIgnoreLeadingWhiteSpace(true).build();
		Iterator<E> iterator = csvToBean.iterator();
		return iterator;
	}
}
