package com.bridgelabz.censusanalyzer;

public class CensusAnalyzerExcepition extends RuntimeException
{
	enum Exception_Error_Type
	{
		INCORRECT_PATH,
		INCORRECT_FILE_TYPE,
		INCORRECT_DELIMETER,
		INCORRECT_HEADER
	};
	
	Exception_Error_Type type;
	public CensusAnalyzerExcepition(Exception_Error_Type type, String message)
	{
		super(type+": "+message);
		this.type = type;
	}
}
