/*
문제 : DFS와 BFS
난이도 : 실버2
유형 : 그래프, DFS, BFS
링크 : https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	static boolean visited[];
	static int[][] graph;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s][e] = graph[e][s] = 1;	
		}
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);

		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb);
		
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int i = 1; i < graph.length; i++) {
			if (graph[v][i] == 1 & !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);
		sb.append(v).append(" ");
		
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			for (int i = 1; i < graph.length; i++) {
				if (graph[pop][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
}