/*
문제 : 시저 암호
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */

public class PG12926 {
	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
	}

	public static String solution(String s, int n) {
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 공백
			if (c == ' ') {
				answer.append(' ');
			}

			// 소문자
			else if (c >= 'a' && c <= 'z') {
				answer.append((char) ((c - 'a' + n) % 26 + 'a'));
			}

			// 대문자
			else {
				answer.append((char) ((c - 'A' + n) % 26 + 'A'));
			}
		}
		return answer.toString();
	}
}
