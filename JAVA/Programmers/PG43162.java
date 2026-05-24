/*
문제 : 네트워크
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
*/

import java.util.Queue;
import java.util.LinkedList;

public class PG43162 {
	static boolean[] visited;

	public static void main(String args[]) {
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(i, computers);
				answer++;
			}
		}
		return answer;
	}

	public static void bfs(int v, int[][] computers) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < computers[cur].length; i++) {
				if (!visited[i] && computers[cur][i] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
