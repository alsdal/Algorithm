/*
문제 : 요리사
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc&
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1865 {
	public static int[][] work;
	public static boolean[] visited;
	public static int N;
	public static double result;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			work = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					work[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = -1;
			visited = new boolean[N];
			permutation(1, 0);
			
			System.out.printf("#" + test_case + " "+"%.6f\n", result * 100);
		}
	}

	public static void permutation(double chance, int depth) {
		if (chance <= result) return;
		if (depth == N) {
			result = Math.max(result, chance);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(chance *(work[depth][i])/100.0, depth + 1);
				visited[i] = false;
			}
		}
	}
}