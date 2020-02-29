/**
 * 
 */
package com.intw.prep.kit.warmup;

/**
 * @author AD79272
 *
 */
public class RepeatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RepeatedString main = new RepeatedString();
		
		long count = main.repeatedString("aba", 10);
		System.out.println("main.count : " + count);

		count = main.repeatedString("a", 1000000000000L);
		System.out.println("main.count : " + count);
		
		count = main.repeatedString("aaa", 1000000000000L);
		System.out.println("main.count : " + count);
		
		count = main.repeatedString("abac", 1000000000000L);
		System.out.println("main.count : " + count);
		
		count = main.repeatedString("abacddaacnmp", 37);
		System.out.println("main.count : " + count);
		
		count = main.repeatedString("cfimaakj", 554045874191L);
		System.out.println("main.count : " + count);
		
		count = main.repeatedString("cfimaakjabc", 554045874191L);
		System.out.println("main.count : " + count);
	}
	
	static long repeatedString(String s, long n) {
		if(s == null || s.isEmpty() || !s.contains("a"))
		{
			return 0;
		}
		
		int acount = getACount(s);
		int length = s.length();
		long mod =  n % length;
		long remaining =  mod >= 0 ? mod : mod + length;
		long total = ((n / length) * acount) + getACount(s.substring(0, (int)remaining));
		
		return total;
    }

	/**
	 * @param substring
	 * @return
	 */
	private static int getACount(String s) {
		int acount = 0;
		for (char c : s.toCharArray()) {
			if(c == 'a')
			{
				acount++;
			}
		}
		
		return acount;
	}

}
