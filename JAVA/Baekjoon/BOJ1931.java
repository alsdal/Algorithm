/*
문제 : 회의실 배정
유형 : 그리디, 정렬
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/1931
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 회의의 수
		int[][] schedule = new int[N][2]; // 회의 시간

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}

		// 회의 시간 끝나는 순으로 정렬
		Arrays.sort(schedule, new Comparator<int[]>() {
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) {
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});

		// 겹치지 않도록 끝나는 시간 기준으로 회의 선택
		int cnt = 0;
		int endTime = 0;
		for (int i = 0; i < N; i++) {
			if (endTime <= schedule[i][0]) {
				endTime = schedule[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
