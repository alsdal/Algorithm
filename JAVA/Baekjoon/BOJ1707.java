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
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1707 {
	static List<Integer>[] list;
	static int[] visited;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			list = new ArrayList[V + 1];
			for (int j = 1; j <= V; j++) {
				list[j] = new ArrayList<Integer>();
			}
			visited = new int[V + 1];

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}

			ans = true;
			for (int j = 1; j <= V; j++) {
				if (visited[j] == 0) {
					dfs(j);
					if (!ans) {
						break;
					}
				}
			}

			if (ans) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void dfs(int v) {
		if(visited[v] == 0) {
			visited[v] = 1;			
		}
		for (int i : list[v]) {
			if (visited[i] == 0) {
				visited[i] = visited[v] * (-1);
				dfs(i);
			} else if (visited[i] == visited[v]) {
				ans = false;
				break;
			}
		}
	}
}
