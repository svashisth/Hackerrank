/**
 * 
 */
package com.intw.prep.kit.array;

import java.util.Arrays;

/**
 * @author AD79272
 *
 */
public class MinimumBribes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumBribes main = new MinimumBribes();

		int[] q = new int[] {};
		main.minimumBribes(q);
		
		q = new int[] {2, 1, 5, 3, 4};
		main.minimumBribes(q);
		
		q = new int[] {2, 5, 1, 3, 4};
		main.minimumBribes(q);
		
		q = new int[] {5, 1, 2, 3, 7, 8, 6, 4};
		main.minimumBribes(q);
		
		q = new int[] {1, 2, 5, 3, 7, 8, 6, 4};
		main.minimumBribes(q);
	}

	static void minimumBribes(int[] q) {
		if(q == null || q.length == 0)
		{
			System.out.println(0);
			return;
		}
		int bribes = 0;
		for (int i = 0; i < q.length; i++) {
			if(q[i] - (i+1) > 2)
			{
				System.out.println("Too chaotic");
				return;
			}
			for(int j = i + 1; j < q.length; j++)
			{
				if(q[i] > q[j])
				{
					bribes++; 
				}
			}
		}
		System.out.println(bribes);
	}

}
