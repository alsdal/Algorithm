/*
문제 : N과 M(1)
유형 : 백트래킹
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/15649
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
