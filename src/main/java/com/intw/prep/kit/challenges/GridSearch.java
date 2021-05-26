/**
 * 
 */
package com.intw.prep.kit.challenges;

/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 * 
 * @author sunil
 *
 */
public class GridSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] G = {"1234", "2345"};
		String[] P = {"34", "45"};
		String res = gridSearch(G, P);
		System.out.println(res);
		
		G = new String[]{"1234", "2345"};
		P = new String[]{"34"};
		res = gridSearch(G, P);
		System.out.println(res);

		G = new String[]{"7283455864","6731158619","8988242643","3830589324","2229505813","5633845374","6473530293","7053106601","0834282956","4607924137"};
		P = new String[]{"9505","3845","3530"};
		res = gridSearch(G, P);
		System.out.println(res);

		G = new String[]{"400453592126560","114213133098692","474386082879648","522356951189169","887109450487496","252802633388782","502771484966748","075975207693780","511799789562806","404007454272504","549043809916080","962410809534811","445893523733475","768705303214174","650629270887160"};
		P = new String[]{"99", "99"};
		res = gridSearch(G, P);
		System.out.println(res);
		
		G = new String[]{"123456","567890","234567","194729"};
		P = new String[]{"1234","5678","2345","4729"};
		res = gridSearch(G, P);
		System.out.println(res);
	}

	static String gridSearch(String[] G, String[] P) {
		if(P == null || G == null || G.length == 0 || P.length == 0 | P.length > G.length || P[0].length() > G[0].length())
		{
			return "NO";
		}

		int endRow = G.length > P.length ? G.length - P.length : P.length - 1; 
		int endCol = G[0].length() > P[0].length() ? G[0].length() - P[0].length() : P[0].length() - 1;
		for(int r = 0; r <= endRow; r++)
		{
			for(int c=0; c <= endCol; c++)
			{
				if(search(G, r, c, P) == 1)
				{
					return "YES";
				}
			}
		}
		
		return "NO";
    }

	/**
	 * Returns 0 if there is a potential match
	 * Returns 1 if exact match is found
	 * Returns -1 if no match
	 * @param g
	 * @param r
	 * @param c
	 * @param p
	 * @return
	 */
	private static int search(String[] g, int r, int c, String[] p) {
		boolean isPotentialMatch = false;
		char[] gridCharArray = g[r].toCharArray();
		char[] patternCharArray = p[0].toCharArray();
		if(gridCharArray[c] == patternCharArray[0] && gridCharArray[c+1] == patternCharArray[1])
		{
			if(p.length == 1)
			{
				isPotentialMatch = true;
			}
			if(p.length > 1)
			{
				if(g[r+1].toCharArray()[c] == p[1].toCharArray()[0])
				{
					isPotentialMatch = true;
				}
			}
		}
		
		if(isPotentialMatch)
		{
			int pRow = 0;
			for(int row = r; row < r+p.length; row++)
			{
				if(!match(g,row,pRow++,c,p))
				{
					return -1;
				}
			}
			return 1;
		}
		
		return -1;
	}

	private static boolean match(String[] g, int row, int pRow, int c, String[] p) {
		char[] gridCharArray = g[row].toCharArray();
		char[] patternCharArray = p[pRow].toCharArray();
		int i = 0;
		for(int col = c; col < c+p[0].length(); col++)
		{
			if(!( gridCharArray[col] == patternCharArray[i++]))
			{
				return false;
			}
		}
		return true;
	}
}
