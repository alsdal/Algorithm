/*
문제 : 이상한 문자 만들기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12930
*/

public class PG12930 {
	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;

		for (char c : s.toCharArray()) {
			if (c == ' ') {
				sb.append(c);
				idx = 0;
			} else {
				if (idx % 2 == 0) {
					sb.append(Character.toUpperCase(c));
				} else {
					sb.append(Character.toLowerCase(c));
				}
				idx++;
			}
		}
		return sb.toString();
	}
}
