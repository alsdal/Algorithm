/*
문제 : 이분 그래프
유형 : 그래프, DFS, BFS, 이분그래프
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1707
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1707 {
	static ArrayList<Integer>[] list;
	static int[] visited;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점 개수
			int E = Integer.parseInt(st.nextToken()); // 간선 개수

			list = new ArrayList[V + 1]; // 인접 리스트
			for (int j = 1; j <= V; j++) {
				list[j] = new ArrayList<Integer>();
			}
			visited = new int[V + 1];

			// 리스트 입력
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}

			ans = true;
			// DFS 수행
			for (int j = 1; j <= V; j++) {
				if (visited[j] == 0) {
					dfs(j);
					if (!ans)
						break;
				}
			}

			// 정답 출력
			if (ans) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void dfs(int v) {
		Stack<Integer> s = new Stack<>();
		s.push(v);
		visited[v] = 1;
		while (!s.isEmpty()) {
			int node = s.pop();
			for (int i : list[node]) {
				// 처음 방문하는 노드 이전 노드와 다른 집합 처리
				if (visited[i] == 0) {
					s.push(i);
					visited[i] = visited[node] * (-1);
				}
				// 인접 노드가 같은 집합이라면 break
				else if (visited[i] == visited[node]) {
					ans = false;
					break;
				}
			}
		}
	}
}
