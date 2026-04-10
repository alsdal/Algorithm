/*
문제 : N과 M(2)
유형 : 백트래킹
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/15650
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 자연수
		M = Integer.parseInt(st.nextToken()); // 중복 없이 M개 고른 수열
		arr = new int[M];

		dfs(1, 0);
		System.out.println(sb);
	}

	public static void dfs(int at, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
}
