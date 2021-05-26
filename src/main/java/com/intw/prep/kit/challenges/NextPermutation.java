package com.intw.prep.kit.challenges;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * 
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 * 
 * @author sunil
 *
 */
public class NextPermutation {
	
	public static void main(String[] args) {
		String res = biggerIsGreater("abc");
		System.out.println(res);
		
		res = biggerIsGreater("cba");
		System.out.println(res);
		
		res = biggerIsGreater("abcd");
		System.out.println(res);
		
		res = biggerIsGreater("hefg");
		System.out.println(res);
		
		res = biggerIsGreater("dhck");
		System.out.println(res);
		
		res = biggerIsGreater("dkhc");
		System.out.println(res);
		
		res = biggerIsGreater("zzzz");
		System.out.println(res);
	}
	
	// Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
    	if(w == null || w.trim().toString().isEmpty())
    	{
    		return w;
    	}
    	w = w.trim();
    	 // Find longest non-increasing suffix
    	char[] charArray = w.toCharArray();
    	int i = w.length() - 1;
    	while(i > 0 && charArray[i-1] >= charArray[i])
    	{
    		i--;
    	}
    	// Now i is the head index of the suffix
        
        // Are we at the last permutation already?
    	if(i <= 0)
    	{
    		return "no answer";
    	}
    	
    	int j = charArray.length - 1;
        while (charArray[j] <= charArray[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i
        
        // Swap the pivot with j
        char temp = charArray[i - 1];
        charArray[i - 1] = charArray[j];
        charArray[j] = temp;
        
     // Reverse the suffix
        j = charArray.length - 1;
        while (i < j) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        
        // Successfully computed the next permutation
    	return new String(charArray);
    }
}
