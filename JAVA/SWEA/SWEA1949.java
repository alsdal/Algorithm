/*
문제 : 등산로 조성
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1949 {
	static int[][] path;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int N, K, maxDepth;
	static boolean used;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxDepth = 1;
			used = false;
			int result = 0;

			// 그래프 입력
			path = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					path[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 가장 높은 봉우리 높이 찾기
			int peak = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (path[i][j] > peak) {
						peak = path[i][j];
					}
				}
			}
			// 높은 봉우리에서 dfs 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (path[i][j] == peak) {
						visited = new boolean[N][N];
						result = dfs(i, j, peak, 1);
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static int dfs(int x, int y, int h, int d) {
		maxDepth = Math.max(maxDepth, d);
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
				if (path[nx][ny] < h) {
					dfs(nx, ny, path[nx][ny], d + 1);
				} else if (path[nx][ny] - K < h && !used) {
					used = true;
					dfs(nx, ny, path[x][y] - 1, d + 1);
					used = false;
				}
			}
		}
		visited[x][y] = false;
		return maxDepth;
	}
}
