/*
문제 : 거의 소수
유형 : 소수
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/1456
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int sqrtB = (int) Math.sqrt(B);
		long[] isPrime = new long[sqrtB + 1];

		for (int i = 2; i <= sqrtB; i++) {
			isPrime[i] = i;
		}

		// 소수 구하기
		for (int i = 2; i * i <= sqrtB; i++) { // 오버플로우 방지
			if (isPrime[i] != 0) {
				for (int j = i * i; j <= sqrtB; j += i) { // 배수 지우기
					isPrime[j] = 0;
				}
			}
		}

		// 거의 소수 개수 구하기
		int cnt = 0;
		for (int i = 2; i <= sqrtB; i++) {
			if (isPrime[i] != 0) {
				long temp = (long) i*i;
				while (temp <= B) {
					if (temp >= A) {
						cnt++;
					}
					if(temp > B / i) break;
					temp *= i; // 거듭제곱
				}
			}
		}
		System.out.println(cnt);
	}
}
