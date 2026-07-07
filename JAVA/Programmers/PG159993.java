/*
문제 : 미로 탈출
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159993
*/

import java.util.LinkedList;
import java.util.Queue;

public class PG159993 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE" }));
		System.out.println(solution(new String[] { "LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO" }));
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int m, n;
	static char[][] map;
	static boolean[][] visited;

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

	public static int solution(String[] maps) {
		m = maps[0].length();
		n = maps.length;
		int sx = 0, sy = 0;
		int lx = 0, ly = 0;
		int ex = 0, ey = 0;

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = maps[i].charAt(j);
				if (map[i][j] == 'S') {
					sx = j;
					sy = i;
				} else if (map[i][j] == 'L') {
					lx = j;
					ly = i;
				} else if (map[i][j] == 'E') {
					ex = j;
					ey = i;
				}
			}
		}
		
		// 시작지점에서 레버까지의 최단 거리
		int toLever = bfs(map, sx, sy, lx, ly);
		if (toLever == -1) {
			return -1;
		}

		// 레버에서 출구까지의 최단 거리
		int toExit = bfs(map, lx, ly, ex, ey);
		if (toExit == -1) {
			return -1;
		}

		return toLever + toExit;
	}

	public static int bfs(char[][] map, int sx, int sy, int ex, int ey) {
		boolean[][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(sx, sy, 0));
		visited[sy][sx] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.x == ex && cur.y == ey) {
				return cur.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
					continue;
				}
				if (visited[ny][nx] == true) {
					continue;
				}
				if (map[ny][nx] == 'X') {
					continue;
				}

				visited[ny][nx] = true;
				queue.offer(new Node(nx, ny, cur.dist + 1));
			}

		}
		return -1;
	}
}
