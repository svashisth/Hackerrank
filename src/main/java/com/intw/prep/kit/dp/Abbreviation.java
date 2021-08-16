package com.intw.prep.kit.dp;

/**
 * 
 * https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 * not complete
 */
public class Abbreviation {

	public static void main(String[] args) {
		String abbreviation = abbreviation("daBcd", "ABC");
		System.out.println(abbreviation);
		
		abbreviation = abbreviation("AbcDE", "ABDE");
		System.out.println(abbreviation);
		
		abbreviation = abbreviation("AbcDE", "AFDE");
		System.out.println(abbreviation);
	}

	public static String abbreviation(String a, String b) {
		if(a == null || a.isBlank() || b == null || b.isBlank())
		{
			return "YES";
		}
		
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		int bIndx = 0;
		for(int i = 0; i < charArrayA.length; i++)
		{
			if(charArrayB[bIndx] == Character.toUpperCase(charArrayA[i]))
			{
				if(bIndx >= charArrayB.length - 1) 
					break; 
				bIndx++;
			}
		}
		
		if(bIndx == charArrayB.length-1)
			return "YES";
		
		return "NO";
	}
}
