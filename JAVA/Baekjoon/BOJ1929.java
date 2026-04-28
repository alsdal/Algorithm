/*
문제 : 소수 구하기
유형 : 정수론, 소수, 에라토스테네스의 채
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/1929
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 소수이면 true인 boolean 배열
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		// 제곱근까지 수행
		for (int i = 2; i * i <= N; i++) {
			// i의 배수 == 소수 아닌 값 false 처리
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// 소수값 출력
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}
}
