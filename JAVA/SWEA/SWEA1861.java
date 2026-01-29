/*
문제 : 정사각형 방
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1861 {
	static int[][] rooms;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, maxDepth, minRoom;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			maxDepth = 1;
			// 그래프 입력
			N = Integer.parseInt(br.readLine());
			minRoom = N * N;
			rooms = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// dfs 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, rooms[i][j]);
				}
			}
			System.out.println("#" + test_case + " " +minRoom + " " + maxDepth);
		}
	}

	public static void dfs(int x, int y, int d, int roomNo) {
        if (d > maxDepth) {
            maxDepth = d;
            minRoom = roomNo;
        } else if (d == maxDepth) {
            minRoom = Math.min(minRoom, roomNo);
        }
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (rooms[x][y] + 1 == rooms[nx][ny]) {
					dfs(nx, ny, d + 1, roomNo);
				}
			}
		}
	}
}
