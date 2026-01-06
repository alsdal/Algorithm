/*
문제 : 동전 0
유형 : 그리디
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/11047
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N - 1; i >= 0; i--) {
			if (K >= coins[i]) {
				cnt += K / coins[i];
				K = K % coins[i];
			}
		}
		System.out.println(cnt);
	}
}
