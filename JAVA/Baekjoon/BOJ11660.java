/*
문제 : 구간 합 구하기 5
유형 : 누적합
난이도 : 실버1
링크 : https://www.acmicpc.net/problem/11660
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합 구해야하는 횟수
		int[][] arr = new int[N + 1][N + 1];

		// 누적합 계산
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
			}
		}

		// 구간합 계산
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]);
		}
	}
}


/*
public class BOJ11660 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	int[][] arr = new int[N + 1][N + 1];
	int[][] pfs = new int[N + 1][N + 1];
	
	for (int i = 1; i <= N; i++) {
		st = new StringTokenizer(br.readLine());
		for (int j = 1; j <= N; j++) {
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			pfs[i][j] = pfs[i][j-1] + pfs[i-1][j] - pfs[i-1][j-1] + arr[i][j];
		}
	}
	
	for (int i = 0; i < M; i++) {
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
	
		int result = pfs[x2][y2] - pfs[x1-1][y2] - pfs[x2][y1-1] + pfs[x1-1][y1-1];

		System.out.println(result);
	}
}
}
*/