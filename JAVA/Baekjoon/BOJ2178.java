/*
문제 : 미로 탐색
유형 : 그래프, BFS
난이도 : 실버1
링크 : https://www.acmicpc.net/problem/2178
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static int[][] maze;
	static int N, M;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N개의 줄
		M = Integer.parseInt(st.nextToken()); // M개의 정수
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0, 0));
	}

	static int bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b });

		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int x = next[0];
			int y = next[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					maze[nx][ny] = maze[x][y] + 1;
				}
			}
		}
		return maze[N - 1][M - 1];
	}
}