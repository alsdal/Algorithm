/*
문제 : 랜선 자르기
유형 : 이분탐색
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/1654
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long left = 1;
		long right = 0;
		int[] lines = new int[K];

		for (int i = 0; i < K; i++) {
			int line = Integer.parseInt(br.readLine());
			lines[i] = line;
			right = Math.max(right, line);
		}

		long answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			for (int len : lines) {
				cnt += len / mid;
			}

			if (cnt >= N) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
