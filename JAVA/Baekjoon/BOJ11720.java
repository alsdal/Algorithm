
/*
문제 : 수들의 합 5
유형 : 투포인터, 슬라이딩 윈도우
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/2018
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] += arr[i - 1] + i;
		}
		int start = 0;
		int end = 0;
		int cnt = 0;

		while (start < N) {
			if (end < N) {
				if (arr[end] - arr[start] == N) {
					end++;
					cnt++;
				} else if (arr[end] - arr[start] < N) {
					end++;
				} else {
					start++;
				}
			} else {
				if (arr[end] - arr[start] == N) {
					cnt++;
				}
				start++;
			}
		}
		System.out.println(cnt);
	}
}