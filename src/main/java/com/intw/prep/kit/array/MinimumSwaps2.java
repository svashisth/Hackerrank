/**
 * 
 */
package com.intw.prep.kit.array;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] a) {
    	int swap=0;
        for(int i=0;i<a.length;i++){
            if(i+1!=a[i]){
                int t=i;
                while(a[t]!=i+1){
                    t++;  
                }
                int temp=a[t];
                a[t]=a[i];
                a[i]=temp;
                swap++;
            }
        }
        return swap;
    }

    public static void main(String[] args) throws IOException {
        int minimumSwaps = minimumSwaps(new int[] {2,1,4,5,6,8,7,3});
        System.out.println(minimumSwaps);
        
        minimumSwaps = minimumSwaps(new int[] {2,3,4,1,5});
        System.out.println(minimumSwaps);
        
        minimumSwaps = minimumSwaps(new int[] {1,3,5,2,4,6,7});
        System.out.println(minimumSwaps);
    }
}
