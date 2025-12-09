import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 구간 합 구하기 4
유형 : 누적합
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/11659
 */

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] pfs = new int[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			pfs[i] = pfs[i - 1] + Integer.parseInt(st.nextToken());
		}

		int a = 0;
		int b = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(pfs[b] - pfs[a - 1]).append('\n');
		}
		System.out.println(sb);
	}
}
