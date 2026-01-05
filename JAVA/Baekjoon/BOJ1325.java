/*
문제 : 효율적인 해킹
유형 : 그래프, DFS, BFS
난이도 : 실버1
링크 : https://www.acmicpc.net/problem/1325
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
	static int N, M;
	static ArrayList<Integer>[] pc;
	static int[] numHacked; // 해킹 가능한 최대 컴퓨터 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pc = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			pc[i] = new ArrayList<>();
		}
		numHacked = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			pc[B].add(A);
		}

		// 모든 컴퓨터에 대해 BFS 수행
		int maxHacked = 0;
		for (int i = 1; i <= N; i++) {
			numHacked[i] = bfs(i);
			maxHacked = Math.max(numHacked[i], maxHacked);
		}

		// 최대 해킹 가능한 컴퓨터 번호 저장
		for (int i = 1; i <= N; i++) {
			if (numHacked[i] == maxHacked) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int cnt = 0; // 해킹 가능한 컴퓨터 수
		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : pc[node]) {
				if (!visited[i]) {
					queue.add(i);
					cnt++;
					visited[i] = true;
				}
			}
		}
		return cnt;
	}
}
