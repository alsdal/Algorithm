package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static int[][] maze;
	static int N;
	static int M;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];

		// 그래프 입력
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0,0));
	}
	
	public static int bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		
		while(!queue.isEmpty()) {
			int[] pop = queue.poll();
			int x = pop[0];
			int y = pop[1];
			// 방향벡터. 12시부터 시계방향으로 대입
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 경계값 검사
				if(nx>=0 && ny >= 0 && nx<N && ny<M) {
					// 벽(0)이 아니면서 방문하지 않은 경로(1)일 때
					if(maze[nx][ny]==1) {
						maze[nx][ny] = maze[x][y] + 1; // 이동한 거리 갱신
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		return maze[N-1][M-1];
	}
}
