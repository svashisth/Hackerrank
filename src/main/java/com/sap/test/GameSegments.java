/**
 * 
 */
package com.sap.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunil
 *
 */
public class GameSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> coins = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(0);
			add(1);
		}};
		int sg = playSegments(coins);
		System.out.println(sg);
		
		coins = new ArrayList<Integer>() {{
			add(1);
			add(0);
			add(0);
			add(1);
			add(0);
		}};
		sg = playSegments(coins);
		System.out.println(sg);
		
		coins = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(1);
			add(0);
			add(1);
		}};
		sg = playSegments(coins);
		System.out.println(sg);
		
		coins = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(0);
			add(0);
			add(1);
		}};
		sg = playSegments(coins);
		System.out.println(sg);
		
		coins = Arrays.asList(0,1,1,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,1,1,0,1,0,0,1,1,0,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
		sg = playSegments(coins);
		System.out.println(sg);
	}

	/*
     * Complete the 'playSegments' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY coins as parameter.
     */

    public static int playSegments(List<Integer> coins) {
	    if(coins == null || coins.isEmpty())
	    {
	    	return 0;
	    }

	    int listSize = coins.size();
	    int zeroCount = count0s(coins);
	    int onesCount = listSize - zeroCount; 
	    if(zeroCount >= onesCount)
	    {
	    	return 0;	//let player 2 play
	    }
	    
//		int mid = listSize % 2 == 0 ? listSize/2 : listSize/2 + 1;
//	    
//	    int[] array = coins.parallelStream().mapToInt(i->i).toArray();
	    int p1 = 0, p2 = onesCount - zeroCount;
	    int segment = 0;
	    for(int a = 0; a < coins.size(); a++)
	    {
	    	segment++;
	    	int coin = coins.get(a);
	    	if(coin == 1)
	    	{
	    		p1 = p1 + coin;
	    		p2 = p2 - coin;
	    		if(p1 > p2)
	    		{
	    			return segment;
	    		}	    		
	    	}
	    	else
	    	{
	    		p1 = p1 - 1;
	    		p2 = p2 + 1;
	    	}
	    }
	    if(p1 > p2)
	    {
	    	return segment;
	    }
	    return 0;
    }

	private static int count0s(List<Integer> coins) {
		int zeroCount  = 0;
		for(Integer integer : coins)
		{
			if(integer == 0)
			{
				zeroCount++;
			}
		}
		return zeroCount;
	}
}
