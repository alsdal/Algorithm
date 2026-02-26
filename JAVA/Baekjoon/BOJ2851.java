/*
문제 : 슈퍼 마리오
유형 : 누적합
난이도 : 브론즈1
링크 : https://www.acmicpc.net/problem/2851
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int result = 0;

		for (int i = 1; i <= 10; i++) {
			sum += Integer.parseInt(br.readLine());
			if (Math.abs(sum - 100) <= Math.abs(result - 100)) {
				result = sum;
			}
		}
		System.out.println(result);
	}
}
