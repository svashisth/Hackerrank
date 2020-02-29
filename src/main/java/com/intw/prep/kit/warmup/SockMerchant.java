/**
 * 
 */
package com.intw.prep.kit.warmup;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SockMerchant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SockMerchant main = new SockMerchant();

		int[] arr = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		int pairs = main.sockMerchant(9, arr);
		System.out.println("main\t" + pairs);
	}

	static int sockMerchant(int n, int[] ar) {
		if (n <= 1) {
			return 0;
		}
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			int j = ar[i];
			if (!map.containsKey(j)) {
				map.put(j, 0);
			} else {
				map.remove(j);
				count++;
			}
		}

		return count;
	}

}
