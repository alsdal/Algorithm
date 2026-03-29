/*
문제 : 신기한 소수
유형 : 소수, DFS, 백트래킹
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/2023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}

	public static void dfs(int num, int digit) {
		// N자리 소수 출력
		if (digit == N) {
			if (isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		// 새 자릿수에 홀수 추가, 소수이면 재귀
		for (int i = 1; i < 10; i += 2) {
			if (isPrime(num * 10 + i)) {
				dfs(num * 10 + i, digit + 1);
			}
		}
	}

	// 소수 판별
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
