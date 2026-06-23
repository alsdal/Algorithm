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

	static List<String> list = new ArrayList<>();
	static String[] vowels = { "A", "E", "I", "O", "U" };

	public static int solution(String word) {
		dfs("");
		return list.indexOf(word) + 1;
	}

	public static void dfs(String str) {
		if (str.length() > 5) {
			return;
		}

		if (!str.equals("")) {
			list.add(str);
		}

		for (String v : vowels) {
			dfs(str + v);
		}
	}
}
