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
					// 사람인 경우 bfs 탐색
					if (places[t][i].charAt(j) == 'P') {
						if (!bfs(i, j, places[t])) {
							isValid = false;
							break;
						}
					}
				}
				if (!isValid) {
					break;
				}
			}
			// 결과에 따라 정답 추가
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

		// 시작점 초기화
		queue.offer(new int[] { x, y, 0 });
		visited[x][y] = true;

		// 좌표, 거리 입력하여 탐색
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int dist = cur[2];

			// 거리가 2이면 탐색 종료
			if (dist == 2) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				// 경계값 검사
				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
					continue;
				}

				// 방문 검사
				if (visited[nx][ny]) {
					continue;
				}

				// 벽인 경우
				if (place[nx].charAt(ny) == 'X') {
					continue;
				}

				// 사람인 경우
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
