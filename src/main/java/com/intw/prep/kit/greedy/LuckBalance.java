package com.intw.prep.kit.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 *
 */
class Result {

	/*
	 * Complete the 'luckBalance' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. 2D_INTEGER_ARRAY contests
	 */

	public static int luckBalance(int k, List<List<Integer>> contests) {
		PriorityQueue<Integer> minHeap = new PriorityQueue();

		int impCount = 0;
		int totalLuck = 0;
		for (List<Integer> list : contests) {
			if (list.get(1) == 1) {
				impCount++;
				minHeap.add(list.get(0));
			}
			totalLuck += list.get(0);
		}

		if (!minHeap.isEmpty()) {
			int toRemove = impCount - k;
			for (int i = 0; i < toRemove; i++) {
				totalLuck -= 2*minHeap.poll();
			}
		}
		return totalLuck;
	}

}

public class LuckBalance {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\out.txt"));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> contests = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				contests.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.luckBalance(k, contests);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}