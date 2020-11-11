package com.bridgelabz.censusanalyzer;

public class CSVBuilderFactory {

	/**
	 * Use this to create a OpenCsvBuilder object. OpenCsvBuilder class implements ICsvBuilder interface,
	 * therefore the returned object is also of type ICsvBuilder. ICsvBuilder class defines a method 
	 * getCsvIterator to return a beanToCsv object's Iterator.
	 * @return Returns a new OpenCsvBuilder object.
	 */
	public static ICsvBuilder createCsvBuilder() 
	{
		return new CommonCsvBuilder();
	}
}
