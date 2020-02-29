/**
 * 
 */
package com.intw.prep.kit.array;

import java.util.Arrays;

/**
 *
 */
public class ArrayManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayManipulation main = new ArrayManipulation();

		int[][] queries = new int[][] {{1,5,3},{4,8,7},{6,9,1}};
		long maxVal = main.arrayManipulation(10, queries);
		System.out.println("main.maxVal : " + maxVal);
		
		queries = new int[][] {{1,2,100},{2,5,100},{3,4,100}};
		maxVal = main.arrayManipulation(5, queries);
		System.out.println("main.maxVal : " + maxVal);
		
		queries = new int[][] {{2, 6, 8},{3,5,7}, {1,8,1}, {5,9,15}};
		maxVal = main.arrayManipulation(10, queries);
		System.out.println("main.maxVal : " + maxVal);
	}
	
	static long arrayManipulation(int n, int[][] queries) {
		if(n < 1)
		{
			return 0;
		}
		
		long ar[] = new long[n];
		for(int i = 0; i < queries.length; i ++)
		{
			ar[queries[i][0]-1] += queries[i][2];
			if(queries[i][1] < n)
			{
				ar[queries[i][1]] -= queries[i][2];
			}
		}
		
		long max = -1;
		long sum = 0; 
		for (int i = 0; i < n; i++) {
			sum += ar[i];
			if(sum > max)
			{
				max = sum;
			}
		}
		
		return max;
    }

}
