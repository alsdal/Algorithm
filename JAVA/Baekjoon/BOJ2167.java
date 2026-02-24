import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N개의 줄
		int M = Integer.parseInt(st.nextToken()); // M개의 정수
		int[][] arr = new int[N + 1][M + 1]; // 2차원 누적합 배열

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(br.readLine()); // 합을 구할 부분의 개수
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(arr[x][y] - arr[x][j - 1] - arr[i - 1][y] + arr[i - 1][j - 1]);
		}
	}
}
