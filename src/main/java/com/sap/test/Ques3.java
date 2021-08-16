package com.sap.test;

public class Ques3 {

	public static void main(String[] args) {
	
		String s1 = "ABC";
		String s2 = "ABCBABC";
		long subsequenceCount = getSubsequenceCount(s1, s2);
		System.out.println(subsequenceCount);
		
		s1 = "HRW";
		s2 = "HERHRWS";
		subsequenceCount = getSubsequenceCount(s1, s2);
		System.out.println(subsequenceCount);
		
		s1 = "ELO";
		s2 = "HELLOWORLD";
		subsequenceCount = getSubsequenceCount(s1, s2);
		System.out.println(subsequenceCount);
		
		s1 = "abc";
		s2 = "abccbcc";
		subsequenceCount = getSubsequenceCount(s1, s2);
		System.out.println(subsequenceCount);
	}
	
	/*
     * Complete the 'getSubsequenceCount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static long getSubsequenceCount(String s1, String s2) {
    	if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
    	{
    		return 0;
    	}
    	if(s1==s2 || s1.equalsIgnoreCase(s2))
    	{
    		return 1;
    	}
    	
    	char[] charArrayS1 = s1.toCharArray();
    	char[] charArrayS2 = s2.toCharArray();
    	
    	int[][] mem = new int[s1.length()+1][s2.length()+1];
    	for (int row = 1; row < mem.length; row++) {	
			for (int col = 1; col < mem[row].length; col++)
			{
				if(charArrayS1[row-1] == charArrayS2[col-1])
				{
					mem[row][col] = Math.max(mem[row-1][col-1] + mem[row][col-1], 1);
				}
				else
				{
					mem[row][col] = mem[row][col-1];
				}
			}
		}

		return mem[s1.length()][s2.length()];
    }
}
