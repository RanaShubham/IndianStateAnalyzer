package com.bridgelabz.censusanalyzer;

import java.io.Reader;
import java.util.Iterator;

public interface ICsvBuilder<E>
{
	public Iterator getCsvIterator(Reader reader, Class pojoClass) throws CsvBuilderException;
}
