package com.c1.test;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author sunil
 *
 */
public class CustomSort {
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(6,3,4,5);
		int moves = moves(arr);
		System.out.println(moves);
		
		arr = Arrays.asList(13, 10, 21, 20);
		moves = moves(arr);
		System.out.println(moves);
		
		arr = Arrays.asList(8, 5, 11, 4, 6);
		moves = moves(arr);
		System.out.println(moves);
		
		arr = Arrays.asList(17, 4, 8);
		moves = moves(arr);
		System.out.println(moves);
		
		arr = Arrays.asList(8, 9, 11, 4, 7);
		moves = moves(arr);
		System.out.println(moves);
		
		arr = Arrays.asList(8, 9, 11, 4, 6, 7);
		moves = moves(arr);
		System.out.println(moves);
	}
	
	/*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int moves(List<Integer> arr) {
    	if(arr == null || arr.isEmpty())
    	{
    		return 0;
    	}
    	
    	int minSwaps = 0;
    	
    	int arrSize = arr.size(); 
    	//mid of list
    	int mid = arrSize % 2 == 0 ? (arrSize/2 - 1) : arrSize/2;
    	int j = arrSize - 1;	//hold last index in list
    	//Take 2 pointers i & j move first from begining and second from end
    	//Count a swap if i find an odd and j finds an even
    	for (int i = 0; i < arr.size(); i++) {
    		if(i > mid || j < mid || i==j)
    		{
    			break;
    		}
			if(arr.get(i) % 2 != 0) //odd found in first half of list
			{
				while(j >= mid)
				{
					if(arr.get(j--) % 2 == 0)	//even found in second half of list
					{
						minSwaps++;
						break;
					}
				}
			}
		}
    		
    	return minSwaps;
    }
}
