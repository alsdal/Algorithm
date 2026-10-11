/*
문제 : 가장 먼 노드
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49189
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG49189 {
	static List<List<Integer>> graph;
	static int[] dist;

	public int solution(int n, int[][] edge) {
		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		// 인접 리스트 초기화
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 연결
		for (int[] e : edge) {
			int a = e[0];
			int b = e[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		bfs(1);

		// 가장 먼 노드 거리 구하기
		int maxDist = 0;
		for (int i : dist) {
			maxDist = Math.max(maxDist, i);
		}

		// 가장 먼 노드 개수 구하기

		int answer = 0;
		for (int i : dist) {
			if (i == maxDist) {
				answer++;
			}
		}

		return answer;
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		dist[v] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph.get(cur)) {
				if (dist[next] == -1) {
					queue.add(next);
					dist[next] = dist[cur] + 1;
				}
			}
		}
	}
}
