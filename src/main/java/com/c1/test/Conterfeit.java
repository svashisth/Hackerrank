/**
 * 
 */
package com.c1.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunil
 *
 */
public class Conterfeit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> serialNumber = Arrays.asList("A201550B","ABB19991000Z","XYZ200019Z","ERF200220","SCD203010T");
		int sum = countCounterfeit(serialNumber);
		System.out.println(sum);
		
//		long a = "XYZ200019Z".substring(0, 3).chars().distinct().count();
//		System.out.println(a);
		
		serialNumber = Arrays.asList("QDB2012R20B","RED190250E","RFV201111T","TYU20121000E","AAA198710B","AbC200010E");
		sum = countCounterfeit(serialNumber);
		System.out.println(sum);
		
		boolean validate = upperCaseRule.validate("T5U20121000E");
		System.out.println(validate);
	}

	@FunctionalInterface
	interface ICounterfeitRule
	{
		static List<Integer> validDenomination = Arrays.asList(10,20,50,100,200,500,1000);
		public boolean validate(String serialNo);
		
		default String getDetail() {
			return "Validate serial number for counterfeiting";
		};
	}
	
	static ICounterfeitRule nullCheckRule = (String serialNo) -> ( (serialNo == null || serialNo.isEmpty()) ? false : true);
	static ICounterfeitRule charRule = (String serialNo) -> ( (serialNo.length() < 10 || serialNo.length() > 12) ? false : true);
	static ICounterfeitRule upperCaseRule = (String serialNo) -> {
		String first3Chars = serialNo.substring(0, 3);
		return (  (first3Chars.chars().anyMatch(Character::isLowerCase) ||  first3Chars.chars().distinct().count() < 3 || !first3Chars.chars().allMatch(Character::isAlphabetic)) ? false : true);
	};
	static ICounterfeitRule yearCheckRule = (String serialNo) -> { 
		String yearVal = serialNo.substring(3, 7);		
		try{
			int year = Integer.parseInt(yearVal);
			if(year < 1900 || year > 2019)
			{
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
//			System.err.println("Year not a valid number : " + yearVal);
			return false;
		}
		return true;
	};
	static ICounterfeitRule denominationRule = (String serialNo) -> {
		String denomVal = serialNo.substring(7, serialNo.length()-1);
		try{
			int val = Integer.parseInt(denomVal);
			if(! ICounterfeitRule.validDenomination.contains(val))
			{
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
//			System.err.println("Denomination is not valid : " + denomVal);
			return false;
		}
		return true;
	};
	static ICounterfeitRule lastCharRule = (String serialNo) -> (  Character.isLowerCase(serialNo.substring(serialNo.length()-1).charAt(0)) ? false : true);
	
	static List<ICounterfeitRule> validators = Arrays.asList(nullCheckRule, charRule, upperCaseRule, yearCheckRule, lastCharRule, denominationRule);
	
	private static boolean isValid(String serialNo)
	{
		for (ICounterfeitRule iCounterfeitRule : validators) {
			if(!iCounterfeitRule.validate(serialNo))
			{
				return false;
			}
		}
		return true;
	}

	private static int getDenomination(String serialNo) {
		String denomVal = serialNo.substring(7, serialNo.length()-1);
		return Integer.parseInt(denomVal);
	}
	
	/*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */

    public static int countCounterfeit(List<String> serialNumber) {
    	
    	if(serialNumber == null || serialNumber.isEmpty())
    	{
    		return 0;
    	}
    	
    	int totalSum = 0;	//to hold the sum of valid currency
    	
    	for(String serialNo : serialNumber)
    	{
    		if(isValid(serialNo))
    		{
    			totalSum += getDenomination(serialNo);
    		}
    	}
    	
    	return totalSum;
    }

}
