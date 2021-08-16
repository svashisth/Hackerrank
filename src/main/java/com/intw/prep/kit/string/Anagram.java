package com.intw.prep.kit.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Result {


	/*
	 * Complete the 'makeAnagram' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING a 2. STRING b
	 */

    public static int makeAnagram(String a, String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArray = a.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
		}

		char[] charArrayB = b.toCharArray();
		int size = charArrayB.length + charArray.length;
		int commonCount = 0;
		for (int i = 0; i < charArrayB.length; i++) {
			if (map.containsKey(charArrayB[i]) && map.get(charArrayB[i]) > 0) {
				commonCount++;
				map.put(charArrayB[i], map.get(charArrayB[i]) - 1);
			}
		}

		System.out.println(size - (2 * commonCount));
		return size - 2 * commonCount;
    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
