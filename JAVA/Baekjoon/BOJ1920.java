import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제 : 수 찾기
유형 : 이분탐색
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/1920
 */

public class BOJ1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// N, A 입력
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		// M, X 입력
		int M = Integer.parseInt(br.readLine());
		int[] X = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int start = 0, end = N - 1; // 시작, 끝 인덱스
			boolean isNum = false; // 숫자 존재 여부

			// 이분 탐색
			while (start <= end) {
				int mid = (start + end) / 2;
				// 수 발견
				if (A[mid] == X[i]) {
					isNum = true;
					break;
				}
				// 인덱스 조정
				else if (A[mid] > X[i]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			// 출력
			if (isNum) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}