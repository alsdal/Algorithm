import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
	public static int N, M, B, minHeight, maxHeight, minTime, ansHeight;
	public static int[][] ground;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		// 그래프 입력
		ground = new int[N][M];
		minHeight = Integer.MAX_VALUE;
		maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 땅의 높이 입력 받고 최대, 최소 높이 갱신
			for (int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, height);
				maxHeight = Math.max(maxHeight, height);
				ground[i][j] = height;
			}
		}

		minTime = Integer.MAX_VALUE;
		for (int h = minHeight; h <= maxHeight; h++) {
			int time = 0;
			int removed = 0;
			int added = 0;
			// 각 칸의 땅 높이차 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// h보다 높을 때 제거하는 땅의 수 세기
					if (ground[i][j] > h) {
						removed += ground[i][j] - h;
					}
					// h보다 낮을 때 추가하는 땅의 수 세기
					if (ground[i][j] < h) {
						added += h - ground[i][j];
					}
				}
			}

			// 사용할 수 있는 블록 충분한 경우
			if (removed + B >= added) {
				// 걸리는 시간 계산
				time = (removed * 2) + added;
				if (time <= minTime) {
					minTime = time;
					ansHeight = h;
				}
			}
		}
		// 결과 출력
		System.out.println(minTime + " " + ansHeight);
	}
}
