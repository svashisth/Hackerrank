/**
 * 
 */
package com.intw.prep.kit.array;

/**
 * @author AD79272
 *
 */
public class MinimumSwaps2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumSwaps2 main = new MinimumSwaps2();
		int[] arr = new int[] {4,3,1,2};
		int minimumSwaps = main.minimumSwaps(arr);
		System.out.println("main.minimumSwaps : " + minimumSwaps);
	}

	static int minimumSwaps(int[] arr) {
		if(arr == null || arr.length <= 1)
		{
			return 0;
		}
		
		return 0;
    }
	
}
