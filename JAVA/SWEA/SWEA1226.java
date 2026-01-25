/*
문제 : 미로1
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SWEA1226 {
	static int[][] maze;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			maze = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = s.charAt(j) - '0';
				}
			}
			System.out.println("#" + test_case + " " + dfs(1, 1));
		}
	}

	public static int dfs(int x, int y) {
		if (maze[x][y] == 3) {
			maze[x][y] = 9;
			return 1;
		}
		maze[x][y] = 4;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (maze[nx][ny] == 0 || maze[nx][ny] == 3) {
				if(dfs(nx, ny)==1) {
					return 1;					
				}
			}
		}
		return 0;
	}
}