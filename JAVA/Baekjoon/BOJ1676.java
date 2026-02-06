/*
문제 : 팩토리얼 0의 개수
유형 : 수학
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/1676
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int zeroCnt = 0;
		while (N >= 5) {
			zeroCnt += N / 5;
			N /= 5;
		}
		System.out.println(zeroCnt);
	}
}
