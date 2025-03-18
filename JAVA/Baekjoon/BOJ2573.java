import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//각 좌표의 인접한 바닷물 수 구하기
//t 증가시키며 빙산 감소
//덩어리 개수 판별
public class BOJ2573 {
	public static int[][] graph;
	public static int[][] meltSpeed;
	public static boolean[][] visited;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int N, M, cntIce, time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 그래프 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		meltSpeed = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			cntIce = 0;
			time++;	
			waterCnt(graph); // 빙산 인접한 물의 수 갱신
			meltIce(meltSpeed); // 빙산 녹이기
			
			// 빙산 덩어리 수 세기
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 방문하지 않은 빙산 탐색
					if (!visited[i][j] && graph[i][j] > 0) {
						bfs(i, j);
						cntIce++;
					}
				}
			}

			// 빙산 두 덩어리 이상으로 분리되면 시간 출력
			if (cntIce >= 2) {
				System.out.println(time);
				break;
			}

			// 빙산 남았는지 확인
			boolean isIce = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] > 0) {
						isIce = true;
						break;						
					}
				}
			}
			// 빙산 다 녹았다면 0 출력
			if(!isIce) {
				System.out.println(0);
				break;
			}
		}
	}

	// 빙산에 인접한 바닷물 수 구하기
	public static void waterCnt(int[][] graph) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (graph[x][y] > 0) {
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
							if (graph[nx][ny] == 0) {
								cnt++;
							}							
						}
					}
					meltSpeed[x][y] = cnt;
				}
			}
		}
	}

	// 빙산 높이 감소 시키기
	public static void meltIce(int[][] meltSpeed) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (graph[x][y] > meltSpeed[x][y]) {
					graph[x][y] -= meltSpeed[x][y];
				} else {
					graph[x][y] = 0;
				}
			}
		}
	}

	// 덩어리 개수 세기
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && graph[nx][ny] > 0) {
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}
}
