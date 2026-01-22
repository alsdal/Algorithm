/*
문제 : 좋다
유형 : 투포인터
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1253
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] A = new long[N];
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);

		int result = 0;
		for (int i = 0; i < N; i++) {
			long k = A[i];
			int a = 0;
			int b = N - 1;

			while (a < b) {
				if (A[a] + A[b] == k) {
					// 서로 다른 두 수이어야함
					if (a != i && b != i) {
						result++;
						break;
					} else if (a == i) {
						a++;
					} else if (b == i) {
						b--;
					}
				} else if (A[a] + A[b] < k) {
					a++;
				} else {
					b--;
				}
			}
		}
		System.out.println(result);
	}
}