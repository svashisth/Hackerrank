/**
 * 
 */
package com.intw.prep.kit.challenges;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 * 
 * @author sunil
 *
 */
public class Encryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String res = encryption("haveaniceday");
		System.out.println(res);
		
		res = encryption("chillout");
		System.out.println(res);
		
		res = encryption("feedthedog");
		System.out.println(res);

		res = encryption("wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny");
		System.out.println(res);
		
	}

	static String encryption(String s) {
		if(s == null || s.trim().isEmpty())
		{
			return s;
		}
		s = s.trim();
		long len = s.length();
		long sqrt =  (long) Math.floor(Math.sqrt(len));
		long m = sqrt;
		long n = m+1;
		
		if (m*m == len)
		{
			n = m;
		}
		if(m * n < len)
		{
			m++;
		}
		System.out.println(len + " : " + sqrt);
		System.out.println(m + " : " + n);
		char[] charArray = s.toCharArray();
		int indx = -1;
		StringBuilder res = new StringBuilder("");
		for(int c=0;c<n;c++)
		{
			for(int r=0;r<m;r++)
			{
				indx = r*(int)(n)+c;
				if(indx > len - 1) {
					break;
				}
				res.append(charArray[indx]);
			}
			res.append(" ");
		}
		
		return res.toString();
    }
}
