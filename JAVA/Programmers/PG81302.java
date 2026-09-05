/*
문제 : 거리두기 확인하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81302
*/

import java.util.LinkedList;
import java.util.Queue;

public class PG81302 {
	public static void main(String[] args) {
		int[] arr = solution(new String[][] { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int t = 0; t < places.length; t++) {
			boolean isValid = true;
			for (int i = 0; i < places[t].length; i++) {
				for (int j = 0; j < places[t][i].length(); j++) {
					if (places[t][i].charAt(j) == 'P') {
						if (!bfs(i, j, places[t])) {
							isValid = false;
							break;
						}
					}
				}
			}

			if (isValid) {
				answer[t] = 1;
			} else {
				answer[t] = 0;
			}
		}

		return answer;
	}

	public static boolean bfs(int x, int y, String[] place) {
		boolean[][] visited = new boolean[place.length][place[0].length()];
		Queue<int[]> queue = new LinkedList<>();

		visited[x][y] = true;
		queue.offer(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int dist = cur[2];

			if (dist == 2) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				if (place[nx].charAt(ny) == 'X') {
					continue;
				}

				if (place[nx].charAt(ny) == 'P') {
					return false;
				}

				queue.offer(new int[] { nx, ny, dist + 1 });
				visited[nx][ny] = true;
			}

		}
		return true;
	}

}
