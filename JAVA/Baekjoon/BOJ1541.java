/*
문제 : 잃어버린 괄호
유형 : 그리디, 문자열
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/1541
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int result = 0;

		String[] sub = s.split("-"); // "-" 기준으로 문자열 분리

		for (int i = 0; i < sub.length; i++) {
			int sum = 0; // 괄호 안 숫자 합

			// 괄호 안 숫자 계산
			String[] temp = sub[i].split("\\+");
			for (int j = 0; j < temp.length; j++) {
				sum += Integer.parseInt(temp[j]);
			}

			// 첫번째 괄호는 더하기, 나머지는 빼기
			if (i == 0) {
				result += sum;
			} else {
				result -= sum;
			}
		}
		System.out.println(result);
	}
}
