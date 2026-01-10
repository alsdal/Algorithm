/*
문제 : 단어 정렬
유형 : 정렬
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/1181
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String words[] = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이 같을 경우. compareTo 이용하여 사전순 정렬
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 길이순 정렬
				return s1.length() - s2.length();
			}
		});

		sb.append(words[0]).append('\n');

		for (int i = 1; i < N; i++) {
			// 중복 단어 추가 X
			if (!words[i].equals(words[i - 1])) {
				sb.append(words[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
