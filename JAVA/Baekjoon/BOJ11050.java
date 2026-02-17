/*
문제 : 이항 계수 1
유형 : 조합
난이도 : 브론즈1
링크 : https://www.acmicpc.net/problem/11050
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
	}

	static int factorial(int N) {
		if (N <= 1) {
			return 1;
		}
		return N * factorial(N - 1);
	}
}