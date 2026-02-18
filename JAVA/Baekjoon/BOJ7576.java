/*
문제 : 토마토
유형 : 그래프, BFS
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/7576
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	static int N; // 세로 칸 수
	static int M; // 가로 칸 수
	static int[][] graph; // 토마토 담을 그래프
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<int[]> q = new LinkedList<>();
	static int count = 0; // 토마토 모두 익을 때까지 필요한 최소 날짜

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) { 
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (graph[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						graph[nx][ny] = graph[x][y] + 1;
					}
				}
			}
		}

		// 날짜 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) { // 다 익을 수 없는 경우
					return -1;
				}
				count = Math.max(count, graph[i][j]);
			}
		}

		if (count == 1) { // 처음부터 모두 익어 있는 경우
			return 0;
		} else { // 최소 날짜 반환
			return count - 1;
		}
	}
}
