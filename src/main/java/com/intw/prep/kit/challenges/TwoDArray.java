package com.intw.prep.kit.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 * 
 * @author sunil
 *
 */
public class TwoDArray {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
//    	System.out.println(arr.length);
		int maxSum = -63;
		for (int r = 0; r < arr.length - 2; r++) {
			for (int c = 0; c < arr[0].length - 2; c++) {
				maxSum = Math.max(maxSum, getSumFor(arr, r, c));
			}
		}

		return maxSum;
	}

	private static int getSumFor(int[][] arr, int i, int j) {
		int sum = 0;
		for (int c = j; c < j + 3; c++) {
			sum += arr[i][c] + arr[i + 2][c];
		}
		sum += arr[i + 1][j + 1];

		return sum;
	}

	public static void main(String[] args) throws IOException {
		int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		int result = hourglassSum(arr);
		System.out.println(result);

		arr = new int[][]{ 
			{-9,-9,-9,1,1,1},
			{0,-9,0,4,3,2},
			{-9,-9,-9,1,2,3},
			{0,0,8,6,6,0},
			{0,0,0,-2,0,0},
			{0,0,1,2,4,0} };
		result = hourglassSum(arr);
		System.out.println(result);
		
		arr = new int[][]{ 	
			{1,1,1,0,0,0},
			{0,1,0,0,0,0},
			{1,1,1,0,0,0},
			{0,0,2,4,4,0},
			{0,0,0,2,0,0},
			{0,0,1,2,4,0}
		};
		result = hourglassSum(arr);
		System.out.println(result);

		arr = new int[][]{
			{-1,1,-1,0,0,0},
			{0,-1,0,0,0,0},
			{-1,-1,-1,0,0,0},
			{0,-9,2,-4,-4,0},
			{-7,0,0,-2,0,0},
			{0,0,-1,-2,-4,0}
		};
		result = hourglassSum(arr);
		System.out.println(result);
	}
}
