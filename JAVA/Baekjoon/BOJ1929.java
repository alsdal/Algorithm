/*
문제 : 소수 구하기
유형 : 정수론, 소수, 에라토스테네스의 채
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/1929
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j = 2 * i; j <= N; j = j + i) {
				arr[j] = 0;
			}
		}

		for (int i = M; i <= N; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}

	}
}
