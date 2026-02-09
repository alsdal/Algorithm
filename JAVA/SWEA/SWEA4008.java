/*
문제 : 숫자 만들기
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH&
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA4008 {
	public static int[] ops;
	public static int[] nums;
	public static int N, max, min;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			ops = new int[4];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			// 연산자 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			// 숫자 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			dfs(nums[0], 1);
			System.out.println("#" + test_case + " " + (max - min));
		}
	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				ops[i]--;
				switch (i) {
				case 0:
					dfs(num + nums[idx], idx + 1);
					break;
				case 1:
					dfs(num - nums[idx], idx + 1);
					break;
				case 2:
					dfs(num * nums[idx], idx + 1);
					break;
				case 3:
					dfs(num / nums[idx], idx + 1);
					break;
				}
				ops[i]++;
			}
		}
	}
}