/*
문제 : 무인도 여행
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154540
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG154540 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "X591X", "X1X5X", "X231X", "1XXX1" });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static int[] solution(String[] maps) {
		int rows = maps.length;
		int cols = maps[0].length();
		boolean[][] visited = new boolean[rows][cols];
		List<Integer> list = new ArrayList<>();

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (maps[r].charAt(c) != 'X' && !visited[r][c]) {
					list.add(bfs(r, c, maps, visited));
				}
			}
		}

		if (list.isEmpty()) {
			return new int[] { -1 };
		}

		Collections.sort(list);

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	public static int bfs(int r, int c, String[] maps, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;
		int sum = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			sum += maps[cr].charAt(cc) - '0';

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length()) {
					continue;
				}

				if (maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
					continue;
				}

				queue.offer(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
		return sum;
	}
}
