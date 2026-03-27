/*
문제 : DFS와 BFS
난이도 : 실버2
유형 : 그래프, DFS, BFS
링크 : https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	static boolean visited[];
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		// 정렬하여 작은 수부터 출력
		for (int i = 1; i <= N; i++) {
		    Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);

		System.out.println(sb);
	}

	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for (int i : graph[v]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		sb.append(v + " ");

		while (!queue.isEmpty()) {
			int next = queue.poll();
			for (int i : graph[next]) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}

		}
	}
}