/**
 * 
 */
package com.intw.prep.kit.warmup;

/**
 *
 */
public class CountingValleys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountingValleys main = new CountingValleys();
		
		int valleys = main.countingValleys(8, "UDDDUDUU");
		System.out.println("main.valleys : " + valleys);
		
		valleys = main.countingValleys(8, "DDUUUUDD");
		System.out.println("main.valleys : " + valleys);
		
		valleys = main.countingValleys(8, "UUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUUUUDDDUDDUU");
		System.out.println("main.valleys : " + valleys);
	}

	static int countingValleys(int n, String s) {
		if(n == 0 || s == null || s.isEmpty())
		{
			return 0;
		}
		
		int cnt = 0, vallies = 0;
		for (char c : s.toCharArray()) {
			switch(c)
			{
			case 'U':
				cnt++;
				if(cnt == 0)
				{
					vallies++;
				}
				break;
			case 'D':
				cnt--;
				break;
			}
		}
		return vallies;
	}
}
