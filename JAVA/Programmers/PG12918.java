/*
문제 : 문자열 다루기 기본
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */

public class PG12918 {
	public static void main(String args[]) {
		System.out.println(solution("1234"));
	}

	public static boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (!Character.isDigit(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
