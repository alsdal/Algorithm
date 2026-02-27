/*
문제 : 부분합
유형 : 누적합, 투포인터
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1806
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수열의 길이
		int S = Integer.parseInt(st.nextToken()); // 최소 부분합

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int sum = 0; // 부분합
		int len = Integer.MAX_VALUE; // 부분합 최소 길이

		while (true) {
			if (sum >= S) {
				len = Math.min(e - s, len);
				sum -= arr[s++];
			} 
			else if (e == N) {
				break;
			}
			else {
				sum += arr[e++];
			}
		}
		
		// 결과 출력
		if (len == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(len);
		}
	}
}
