/**
 * 
 */
package com.intw.prep.kit.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Not complete
 *
 */
public class SherlockAndAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SherlockAndAnagrams main = new SherlockAndAnagrams();
		int size = main.sherlockAndAnagrams("abab");
		System.out.println("main.size : " + size);
		
		size = main.sherlockAndAnagrams("ifailuhkqq");
		System.out.println("main.size : " + size);
	}

	static int sherlockAndAnagrams(String s) {
		if(s == null || s.isEmpty())
		{
			return 0;
		}
		
		Map<String, List<Integer>> map = new HashMap<>();
		boolean hasDup = false;
		int indx = 0;
		for (char c : s.toCharArray()) {
			if(map.containsKey(""+c))
			{
				hasDup = true;
				List<Integer> list = map.get(""+c);
				list.add(indx);
			}
			else
			{
				List<Integer> newList = new ArrayList<>();
				newList.add(indx);
				map.put(""+c, newList);
			}
			indx++;
		}
		System.out.println("sherlockAndAnagrams.map : " + map);
		int n = 0;
		if(!hasDup)	//No duplicates -> no anagrams
		{
			return n;
		}
		
		for (String c : map.keySet()) {
			List<Integer> list = map.get(c);
			int size = list.size();
			if(size > 1)
			{
				n+= (size - 1);
				for (int i = 1; i < list.size(); i++) {
					if(list.get(i) - list.get(i-1) > 1)
					{
						n++;
					}
				}
			}
		}
		return n;
	}
}
