import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_5653 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 그리드 정보 입력
			int[][] grid = new int[N + K * 2][M + K * 2];
			int[][] grid2 = new int[N + K * 2][M + K * 2];

			for (int i = K; i < K + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K; j < K + M; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input > 0) {
						grid[i][j] = input;
						grid2[i][j] = 2 * input;
					}
				}
			}

			// K시간 후..
			for (int time = 1; time <= K; time++) {
				int[][] tempGrid = new int[N + K * 2][M + K * 2];
				int[][] tempGrid2 = new int[N + K * 2][M + K * 2];

				for (int i = 0; i < N + K * 2; i++) {
					for (int j = 0; j < M + K * 2; j++) {
						// 살아있는 세포 선택, 수명 감소
						if (grid2[i][j] > 0) {
							grid2[i][j]--;
							// 활성 세포라면 번식
							if (grid2[i][j] == grid[i][j] - 1) {
								// 4방향 탐색
								for (int k = 0; k < 4; k++) {
									int nx = i + dx[k];
									int ny = j + dy[k];
									//
									if (grid[nx][ny] == 0) {
										if (tempGrid[nx][ny] < grid[i][j]) {
											tempGrid[nx][ny] = grid[i][j];
											tempGrid2[nx][ny] = 2 * grid[i][j];
										}
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < N + K * 2; i++) {
					for (int j = 0; j < N + K * 2; j++) {
						if (tempGrid[i][j] > 0) {
							grid[i][j] = tempGrid[i][j];
							grid2[i][j] = tempGrid2[i][j];
						}
					}
				}
			}

			// 개수 세기
			int cnt = 0;
			for (int i = 0; i < N + K * 2; i++) {
				for (int j = 0; j < M + K * 2; j++) {
					if (grid2[i][j] > 0) {
						cnt++;
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}