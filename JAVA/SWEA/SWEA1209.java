/*
문제 : Sum
난이도 : D3
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=1209&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1209 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] arr = new int[100][100];
			int T = Integer.parseInt(br.readLine());

			int max = 0;
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 대각
			for (int i = 0; i < 100; i++) {
				sum += arr[i][i];
				if (sum > max) {
					max = sum;
				}
			}

			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][99 - i];
				if (sum > max) {
					max = sum;
				}
			}

			// 행
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if (sum > max) {
					max = sum;
				}
				sum = 0;
			}

			// 열
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if (sum > max) {
					max = sum;
				}
				sum = 0;
			}

			System.out.println("#" + T + " " + max);
		}
	}
}