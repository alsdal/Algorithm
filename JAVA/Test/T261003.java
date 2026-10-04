import java.util.*;

public class T261003 {
	public int solution(int[][] hall) {
		int rows = hall.length;
		int cols = hall[0].length;

		int exitR = -1;
		int exitC = -1;

		// 가장자리에서 출구 찾기
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				boolean boundary = r == 0 || r == rows - 1 || c == 0 || c == cols - 1;

				if (boundary && hall[r][c] != -1) {
					exitR = r;
					exitC = c;
				}
			}
		}

		int[][] dist = new int[rows][cols];

		for (int[] row : dist) {
			Arrays.fill(row, -1);
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { exitR, exitC });
		dist[exitR][exitC] = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 출구에서 모든 칸까지의 최단 거리 계산
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
					continue;
				}

				if (hall[nr][nc] == -1 || dist[nr][nc] != -1) {
					continue;
				}

				dist[nr][nc] = dist[r][c] + 1;
				queue.offer(new int[] { nr, nc });
			}
		}

		List<Integer> distances = new ArrayList<>();

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (hall[r][c] == 1) {
					// 출구로 갈 수 없는 사람이 있는 경우
					if (dist[r][c] == -1) {
						return -1;
					}

					distances.add(dist[r][c]);
				}
			}
		}

		Collections.sort(distances);

		int time = 0;

		for (int distance : distances) {
			time = Math.max(time + 1, distance);
		}

		return time;
	}
}
