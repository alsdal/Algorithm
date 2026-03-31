/*
문제 : 수 찾기
유형 : 이분탐색
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/1920
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // N개의 정수
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine()); // 찾아야할 정수 개수
		int[] X = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int s = 0;
			int e = N - 1;
			boolean foundNum = false;

			// 이분 탐색
			while (s <= e) {
				int m = (s + e) / 2;
				if (A[m] == X[i]) {
					foundNum = true;
					break;
				} else if (A[m] > X[i]) {
					e = m - 1;
				} else {
					s = m + 1;
				}
			}

			if (foundNum) {
				System.out.println(1);

			} else {
				System.out.println(0);
			}
		}

	}
}