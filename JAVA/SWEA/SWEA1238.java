/*
문제 : Contact
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA1238 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			// 그래프 입력
			graph = new ArrayList[101];
			visited = new boolean[101];
			for (int i = 0; i < 101; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
			System.out.println("#" + test_case + " " + bfs(start));
		}
	}

	public static int bfs(int v) {
		int result = 0;
		int maxDepth = 0;
		Queue<int[]> q = new LinkedList<>();
		visited[v] = true;
		q.add(new int[] {v,0});
				
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int currentNode = node[0];
			int currentDepth = node[1];
//			System.out.println("node: "+ currentNode + " depth: "+ currentDepth+ " result: " + result);
			
			if(maxDepth < currentDepth) {
				maxDepth = currentDepth;
				result = currentNode;
			}
			
			for (int next : graph[node[0]]) {
				if(!visited[next]) {
					q.add(new int[] {next, currentDepth + 1});
					visited[next] = true;
				}
			}
			if(currentDepth == maxDepth) {
				result = Math.max(currentNode,result);
			}
		}
		return result;
	}
}