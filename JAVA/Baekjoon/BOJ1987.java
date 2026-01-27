/*
문제 : 알파벳
유형 : 그래프, DFS, 백트래킹
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1987
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
	static int R, C, maxDepth;
	static char[][] board;
	static boolean[] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로 길이
		C = Integer.parseInt(st.nextToken()); // 가로 길이

		board = new char[R][C];
		visited = new boolean[26]; // 알파벳별로 방문 처리

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(maxDepth);
	}

	static void dfs(int x, int y, int depth) {
		maxDepth = Math.max(depth, maxDepth);
		visited[board[x][y] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[board[nx][ny] - 'A']) {
				visited[board[nx][ny] - 'A'] = true;
				dfs(nx, ny, depth + 1);
				visited[board[nx][ny] - 'A'] = false;
			}
		}
	}
}
