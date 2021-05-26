/**
 * 
 */
package com.sap.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunil
 *
 */
public class Ques1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(5);
			add(6);
			add(8);
			add(8);
			add(5);
		}};
		
		long countMoves = countMoves(list);
		System.out.println(countMoves);
		
		list = new ArrayList<Integer>() {{
			add(3);
			add(4);
			add(6);
			add(6);
			add(3);
		}};
		
		countMoves = countMoves(list);
		System.out.println(countMoves);
	}

	public static long countMoves(List<Integer> numbers) {
		if(numbers == null)
		{
			throw new IllegalArgumentException("Provided list of integers is null");
		}

		if(numbers.isEmpty())
		{
			return 0;
		}
		
		Collections.sort(numbers);
		
//		System.out.println(numbers);
		int[] array = numbers.parallelStream().mapToInt(i->i).toArray();
		long count = 0;
		while(!allEqual(array))
		{
			for (int i=0; i< array.length-1;i++) {
				if(array[i] <= array[i+1])
				{
					array[i]++;
				}
				else if(array[i] > array[i+1])
				{
					array[i+1]++;
				}
			}
//			System.out.println(Arrays.toString(array));
			count++;
		}
		return count;
	}

	private static boolean allEqual(int[] array) {
		if(array[array.length-1] != array[array.length-2] || array[0] != array[array.length-1] || array[array.length/2] != array[array.length-1])
        {
            return false;
        }
		int prev = array[0];
		for (Integer integer : array) {
			if(integer != prev)
			{
				return false;
			}
			prev = integer;
		}
		return true;
	}
}
