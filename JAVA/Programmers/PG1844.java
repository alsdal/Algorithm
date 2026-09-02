/*
문제 : 게임 맵 최단거리
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
*/

import java.util.LinkedList;
import java.util.Queue;

public class PG1844 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
	}

	static class Node {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int n, m;

	public static int solution(int[][] maps) {
		int answer = 0;
		n = maps.length; // 맵 세로 길이
		m = maps[0].length; // 맵 가로 길이

		answer = bfs(maps);
		return answer;
	}

	public static int bfs(int[][] maps) {
		boolean[][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();

		// 시작 위치 초기화
		queue.offer(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int x = cur.x;
			int y = cur.y;

			// 도착지 도달한 경우
			if (x == m - 1 && y == n - 1) {
				return cur.dist;
			}

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}
				if (maps[ny][nx] == 0) {
					continue;
				}

				queue.offer(new Node(nx, ny, cur.dist + 1));
				visited[ny][nx] = true;
			}
		}

		return -1;
	}
}
