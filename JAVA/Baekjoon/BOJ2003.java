/*
문제 : 수들의 합 2
유형 : 누적합, 투포인터
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/2003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 수의 합

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int sum = 0;
		int cnt = 0;

		while (true) {
			if (sum >= M) {
				if (sum == M)
					cnt++;
				sum -= arr[s++];
			} else if (e == N) {
				break;
			} else {
				sum += arr[e++];
			}
		}
		System.out.println(cnt);
	}
}
