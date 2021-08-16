package com.intw.prep.kit.challenges;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem?h_r=next-challenge&h_v=zen
 * 
 * @author sunil
 *
 */
public class SparseArrays {

	// Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
    	if(strings== null || strings.length==0 || queries == null || queries.length==0)
    	{
    		return new int[0];
    	}
    	int[] arr = new int[queries.length];
    	Map<String, Integer> map = new HashMap<String, Integer>(); 

    	for (String string : strings) {
			map.put(string, map.getOrDefault(string, 0) + 1);
		}
    	
    	int i = 0;
    	for (String string : queries) {
			arr[i++] = map.get(string) != null ? map.get(string) : 0;
		}
    	
    	return arr;
    }
    
    public static void main(String[] args) {
    	
    	String[] strings = {"abcde","sdaklfj","asdjf","na","basdn","sdaklfj","asdjf","na","asdjf","na","basdn","sdaklfj","asdjf"};
		String[] queries = {"abcde","sdaklfj","asdjf","na","basdn"};
		int[] res = matchingStrings(strings, queries);
    	System.out.println(Arrays.toString(res));
    	
    	strings = new String[] {"def","de","fgh"};
		queries = new String[] {"de","lmn","fgh"};
		res = matchingStrings(strings, queries);
    	System.out.println(Arrays.toString(res));
    	
    	strings = new String[] {"aba","baba","aba","xzxb"};
		queries = new String[] {"aba","xzxb","ab"};
		res = matchingStrings(strings, queries);
    	System.out.println(Arrays.toString(res));

	}
}
