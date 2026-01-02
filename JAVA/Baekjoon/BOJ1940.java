/*
문제 : 주몽
유형 : 투포인터
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/1940
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int start = 0;
		int end = N - 1;
		int cnt = 0;

		while (start < end) {
			int sum = arr[start] + arr[end];
			if(sum == M) {
				end--;
				cnt++;
			}
			else if(sum < M) {
				start++;
			}
			else {
				end--;
			}
		}
		System.out.println(cnt);
	}
}
