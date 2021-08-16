package com.intw.prep.kit.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {

	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		if(d == arr.size())
		{
			return arr;
		}
		// Write your code here
		List<Integer> list = new ArrayList<Integer>();
		for(int pos = 0; pos < arr.size(); pos++)
		{
			list.add(pos, arr.get(d++));

			if(d >= arr.size())
			{
				d = 0;
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		int d = 2;
		List<Integer> arr = Arrays.asList(1,2,3,4,5);
		List<Integer> rotateLeft = rotateLeft(d, arr);
		System.out.println(rotateLeft);
		
		d = 4;
		arr = Arrays.asList(1,2,3,4,5);
		rotateLeft = rotateLeft(d, arr);
		System.out.println(rotateLeft);
		
		d = 5;
		arr = Arrays.asList(1,2,3,4,5);
		rotateLeft = rotateLeft(d, arr);
		System.out.println(rotateLeft);
		
		d = 1;
		arr = Arrays.asList(1,2,3,4,5);
		rotateLeft = rotateLeft(d, arr);
		System.out.println(rotateLeft);
	}
}
