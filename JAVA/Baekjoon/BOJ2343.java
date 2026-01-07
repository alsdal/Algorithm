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
		st = new StringTokenizer(br.readLine());

		int lectures[] = new int[N]; // 강의
		int start = 0;
		int end = 0;
		int mid = 0;

		// 강의 배열 입력 및 이분 탐색 시작과 끝 설정
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, lectures[i]);
			end += lectures[i];
		}

		// 블루레이 크기 mid 최소값 찾기 위해 이분 탐색
		while (start <= end) {
			int sum = 0; // 강의 크기 부분합
			int cnt = 1; // 필요한 블루레이 개수
			mid = (start + end) / 2;

			// 블루레이에 강의 담아서 필요한 블루레이 개수 세기
			for (int i = 0; i < N; i++) {
				if (sum + lectures[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += lectures[i];
			}

			// 이분 탐색
			if (cnt <= M) {
				end = mid - 1;
			} else if (cnt > M) {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
