/**
 * 
 */
package com.intw.prep.kit.dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 */
public class FrequencyQueries {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		FrequencyQueries main = new FrequencyQueries();
		
		List<List<Integer>> fileQueries = new ArrayList<List<Integer>>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\code-NLP-API\\sts-workspace\\HackerRank\\FreqQueries.txt")));
		String str = null;
		while((str = bufferedReader.readLine()) != null )
		{
			String[] split = str.split(" ");
			List<Integer> qq = new ArrayList();
			for (String num : split) {
				qq.add(Integer.valueOf(num));
			}
			fileQueries.add(qq);
		}
		bufferedReader.close();
		long start = System.currentTimeMillis(); 
		List<Integer> freq = main.freqQuery(fileQueries);
		long end = (System.currentTimeMillis() - start); 
		System.out.println("main.took : " + end + " ms" );
		
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		
		List<Integer> q = new ArrayList<>();
		q.add(1);q.add(5);
		queries.add(q);
		
		List<Integer> q1 = new ArrayList<>();
		q1.add(1);q1.add(6);
		queries.add(q1);
		
		List<Integer> q2 = new ArrayList<>();
		q2.add(3);q2.add(2);
		queries.add(q2);
		
		List<Integer> q3 = new ArrayList<>();
		q3.add(1);q3.add(10);
		queries.add(q3);
		
		List<Integer> q4 = new ArrayList<>();
		q4.add(1);q4.add(10);
		queries.add(q4);
		
		List<Integer> q5 = new ArrayList<>();
		q5.add(1);q5.add(6);
		queries.add(q5);
		
		List<Integer> q6 = new ArrayList<>();
		q6.add(2);q6.add(5);
		queries.add(q6);
		
		List<Integer> q7 = new ArrayList<>();
		q7.add(3);q7.add(2);
		queries.add(q7);
		
		List<Integer> freqQuery = main.freqQuery(queries);
//		System.out.println("main.freqQuery : " + freqQuery);
		
	}
	
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<Integer>();
//		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> query : queries) {			
			int val = query.get(1);
			switch(query.get(0)) 
			{
			case 1:
					map.put(val, map.getOrDefault(val, 0) + 1);
				break;
			case 2:
					if(map.containsKey(val))
					{
						int mapVal = map.get(val);
						if(mapVal > 0)
						{
							map.put(val, mapVal - 1);
						}
						else
						{
							map.remove(val);
						}
					}
				break;
			case 3:
//				i++;
				boolean isPresent = false;
				for (int f : map.values()) {
					if(f == val)
					{
						isPresent = true;
						break;
					}
				}
				if(isPresent)
				{
					result.add(1);
				}
				else
				{
					result.add(0);
				}
				/*if(i == 1700)
				{
					System.out.println(query); 
					System.out.println("freqQuery.query : " + map);
					System.out.println("freqQuery.isPresent : " + isPresent);
				}*/
				break;
			default:
				throw new RuntimeException("Unidentified query");
			}
		}
		
		return result;
	}

	static List<Integer> freqQuery_new(List<int[]> queries) {
		List<Integer> result = new ArrayList<Integer>();
//		int i = 0;
		Map<Integer, Integer> map = new HashMap<>(queries.size());
		for (int[] query : queries) {			
			int val = query[1];
			switch(query[0]) 
			{
			case 1:
					map.put(val, map.getOrDefault(val, 0) + 1);
				break;
			case 2:
					if(map.containsKey(val))
					{
						int mapVal = map.get(val);
						if(mapVal > 0)
						{
							map.put(val, mapVal - 1);
						}
						else
						{
							map.remove(val);
						}
					}
				break;
			case 3:
//				i++;
				if(map.containsValue(val))
				{
					result.add(1);
				}
				else
				{
					result.add(0);
				}
				/*if(i == 1700)
				{
					System.out.println(query); 
					System.out.println("freqQuery.query : " + map);
				}*/
				break;
			default:
				throw new RuntimeException("Unidentified query");
			}
		}
		
		return result;
	}
}
