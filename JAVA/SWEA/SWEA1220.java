/*
문제 : Magnetic
난이도 : D3
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1220 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] arr = new int[100][100];
			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					if (arr[i][j] == 1) {
						for (int y = i; y < 100; y++) {
							if (arr[y][j] == 2) {
								i=y;	// 1 연속으로 만날 경우 인덱스 점프
								cnt++;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}