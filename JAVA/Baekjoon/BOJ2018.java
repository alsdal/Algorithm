/*
문제 : 수들의 합 5
유형 : 투포인터, 슬라이딩 윈도우
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/2018
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int start = 1;
		int end = 1;
		int cnt = 1;
		int sum = 1;

		while (start < N) {
			if (sum == N) {
				sum -= start;
				cnt++;
				start++;
			} else if (sum < N) {
				end++;
				sum += end;
			} else if (sum > N) {
				sum -= start;
				start++;
			}
		}
		System.out.println(cnt);
	}
}

// 누적합 배열 이용
/*
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in)); int N =
 * Integer.parseInt(br.readLine()); int[] arr = new int[N + 1];
 * 
 * for (int i = 1; i < N + 1; i++) { arr[i] += arr[i - 1] + i; }
 * 
 * int start = 0, end = 1, cnt = 0;
 * 
 * while (end <= N) { int sum = arr[end] - arr[start]; if (sum == N) { end++;
 * cnt++; } else if(sum < N) { end++; } else { start++; } }
 * System.out.println(cnt); }
 */