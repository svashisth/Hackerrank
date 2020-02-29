/**
 * 
 */
package com.intw.prep.kit.dict;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HashTablesRansomNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashTablesRansomNote main = new HashTablesRansomNote();

		String[] magazine = {"This", "is", "not", "nice"};
		String[] note = {"This", "is", "nice"};
		main.checkMagazine(magazine, note);
	}
	
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : magazine) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		for (String word : note) {
			Integer val = map.getOrDefault(word, 0);
			if(val < 1)
			{
				System.out.println("No");
				return;
			}
			map.put(word, map.get(word) - 1);
		}
		System.out.println("Yes");
    }

}
