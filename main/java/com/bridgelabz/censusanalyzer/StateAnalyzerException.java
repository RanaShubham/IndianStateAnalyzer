package com.bridgelabz.censusanalyzer;

public class StateAnalyzerException extends RuntimeException
{
	public enum Exception_Error_Type
	{
		INCORRECT_PATH,
		INCORRECT_FILE_TYPE,
		INCORRECT_DELIMETER,
		INCORRECT_HEADER
	};
	
	Exception_Error_Type type;
	public StateAnalyzerException(Exception_Error_Type type, String message)
	{
		super(type+": "+message);
		this.type = type;
	}
}
