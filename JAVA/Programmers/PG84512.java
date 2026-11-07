/*
문제 : 모음 사전
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/84512
*/

import java.util.ArrayList;
import java.util.List;

public class PG84512 {
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}

	// 모음 사전
	static List<String> dictionary = new ArrayList<>();

	// 모음 순서대로 저장
	static String[] vowels = { "A", "E", "I", "O", "U" };

	public static int solution(String word) {
		// dfs로 사전순 단어 저장
		dfs("");

		// 인덱스 출력
		return dictionary.indexOf(word) + 1;
	}

	public static void dfs(String s) {
		if (s.length() > 5) {
			return;
		}

		// 현재 단어 저장
		if (!s.equals("")) {
			dictionary.add(s);
		}

		// 모음 순서대로 붙이기
		for (String v : vowels) {
			dfs(s + v);
		}
	}
}
