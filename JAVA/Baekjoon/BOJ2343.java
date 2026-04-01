/*
문제 : 기타 레슨
유형 : 이분탐색
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/2343
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 강의의 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이의 수
		int[] lectures = new int[N];
		int start = 0;
		int end = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, lectures[i]); // 가능한 블루레이 최소 크기
			end += lectures[i]; // 가능한 블루레이 최대 크기
		}

		// 블루레이의 최소 크기 찾기 위해 이분 탐색
		while (start <= end) {
			int cnt = 1; // 블루레이 개수
			int sum = 0; // 강의 크기 부분합
			int mid = (start + end) / 2;

			// 블루레이 크기가 mid일 때 강의 담아서 필요한 블루레이 개수 세기
			for (int i = 0; i < N; i++) {
				if (sum + lectures[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += lectures[i];
			}
			
			// 이분탐색
			if (cnt <= M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
