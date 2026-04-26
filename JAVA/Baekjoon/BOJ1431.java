/*
문제 : 시리얼 번호
유형 : 정렬, 문자열
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/1431
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 기타의 개수
		String[] S = new String[N];
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}

		Arrays.sort(S, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 길이 비교 정렬
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				}

				// 자릿수 합 비교 정렬
				int s1Sum = getSum(s1);
				int s2Sum = getSum(s2);
				if (s1Sum != s2Sum) {
					return s1Sum - s2Sum;
				}

				// 사전순 정렬
				return s1.compareTo(s2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(S[i] + "\n");
		}
		System.out.println(sb);
	}

	// 자릿수 합 구하는 함수
	static int getSum(String s) {
		int sum = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				sum += c - '0';
			}
		}
		return sum;
	}
}
