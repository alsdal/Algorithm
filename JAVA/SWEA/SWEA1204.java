/*
문제 : 최빈수 구하기
난이도 : D2
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1204 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[101];
			int max = 0;
			int idx = 0;
			
			int test_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());
				arr[score]++;
			}
			for (int i = 0; i < arr.length; i++) {
				if (max <= arr[i]) {
					max = arr[i];
					idx = i;
				}
			}
			System.out.println("#"+test_case+" "+idx);
		}
	}
}