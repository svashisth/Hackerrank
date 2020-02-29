/**
 * 
 */
package com.intw.prep.kit.dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AD79272
 *
 */
public class CountTriplets {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		CountTriplets main = new CountTriplets();
		List<Long> arr = Arrays.asList(1L,5L,5L,25L,125L);
		long triplets = main.countTriplets(arr, 5);
		System.out.println("main.tr : " + triplets);
		
		arr = Arrays.asList(1L,3L,9L,9L,27L,81L);
		triplets = main.countTriplets(arr, 3);
		System.out.println("main.tr : " + triplets);
		
		arr = Arrays.asList(1L,2L,2L,4L);
		triplets = main.countTriplets(arr, 2);
		System.out.println("main.tr : " + triplets);
				
		arr = Arrays.asList(1L,2L,1L,2L,4L);
		triplets = main.countTriplets(arr, 2);
		System.out.println("main.tr : " + triplets);
		
		arr = Arrays.asList(1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L);
		triplets = main.countTriplets(arr, 1);
		System.out.println("main.tr : " + triplets);
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\code-NLP-API\\sts-workspace\\HackerRank\\CountingTripletInput.txt")));
		String str = bufferedReader.readLine();
		String[] split = str.split(",");
		arr = new ArrayList();
		for (String num : split) {
			arr.add(Long.valueOf(num));
		}
		bufferedReader.close();
		triplets = main.countTriplets(arr, 10);
		System.out.println("main.tr : " + triplets);
	}
	
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> t2 = new HashMap<>();
		Map<Long, Long> t3 = new HashMap<>();
		
		long triplets = 0;
		for (int i = 0; i < arr.size(); i++) {
			long num = arr.get(i);
			long secTrip = num*r;
			
			triplets+=t3.getOrDefault(num, 0L);
			if(t2.containsKey(num))
			{
				t3.put(secTrip, t3.getOrDefault(secTrip, 0L) + t2.get(num));
			}
			t2.put(secTrip, t2.getOrDefault(secTrip, 0L) + 1);
		}
		
		return triplets;
    }

}
