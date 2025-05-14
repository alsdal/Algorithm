import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SWEA1868 {
	public static int[][] mines;
	public static boolean[][] visited;
	public static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	public static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 지뢰 입력 받기
			N = Integer.parseInt(br.readLine());
			mines = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					char c = s.charAt(j);
					if (c == '*') {
						mines[i][j] = -1; // 지뢰
					} else {
						mines[i][j] = 9; // 클릭하지 않은 곳
					}
				}
			}
			// 클릭하지 않은 곳(9)에 대해 인접 지뢰 개수 구하고 그래프 갱신
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mines[i][j] == 9) {
						mines[i][j] = findMine(i, j);
					}
				}
			}
			
			// 최소 클릭 횟수 출력
			System.out.println("#" + test_case + " " + cntClick());
		}
	}

	// 인접한 지뢰 개수 반환
	public static int findMine(int x, int y) {
		int cntMine = 0;
		// 8방향 탐색
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (mines[nx][ny] == -1) {
					cntMine++;
				}
			}
		}
		return cntMine;
	}

	// 클릭 횟수 반환
	public static int cntClick() {
		int clicks = 0;
		clicks += clickZero(); // 0영역의 개수 더하고 방문 처리
		// 나머지 방문하지 않은 숫자 개수 더하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					clicks++;
				}
			}
		}
		return clicks;
	}

	// 0의 인접칸과 지뢰칸 방문처리, 0영역의 개수 반환
	public static int clickZero() {
		int zeros = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 0과 인접한 칸에 대해 bfs 수행하여 0영역의 개수 구하기
				if (mines[i][j] == 0 && !visited[i][j]) {
					bfs(i, j); // bfs 사용하여 0영역 방문처리하기
					zeros++;
				}
				// 지뢰일 때 방문처리
				if (mines[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		return zeros;
	}
	// 0 인접한 영역 구하기
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			// 8방향 탐색
			for (int i = 0; i < 8; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (mines[nx][ny] == 0) { // 0이면 큐에 추가
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
	}
}