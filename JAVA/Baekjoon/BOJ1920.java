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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 주어지는 정수 개수
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine()); // 존재하는지 알아낼 정수의 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			int s = 0;
			int e = N - 1;
			boolean hasNum = false;

			// 이분 탐색
			while (s <= e) {
				int m = (s + e) / 2;
				if (num == A[m]) {
					hasNum = true;
					break;
				} else if (num < A[m]) {
					e = m - 1;
				} else {
					s = m + 1;
				}
			}

			if (hasNum) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}
}