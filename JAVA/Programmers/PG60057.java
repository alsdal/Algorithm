/*
문제 : 문자열 압축
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
*/

public class PG60057 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}

	public static int solution(String s) {
		int minLength = s.length();

		if (s.length() == 1)
			return 1;

		for (int unit = 1; unit <= s.length() / 2; unit++) {
			StringBuilder sb = new StringBuilder();
			
			String prevString = s.substring(0, unit);
			int cnt = 1;

			// 단위 문자열 처리
			for (int i = unit; i < s.length(); i += unit) {
				int end = Math.min(i + unit, s.length());
				String curString = s.substring(i, end);

				if (prevString.equals(curString)) {
					cnt++;
				} else {
					// 반복 문자열 추가
					if (cnt > 1) {
						sb.append(cnt);
					}
					sb.append(prevString);
					
					// 문자열 갱신
					prevString = curString;
					cnt = 1;
				}
			}

			// 남은 문자열 처리
			if (cnt > 1) {
				sb.append(cnt);
			}
			sb.append(prevString);

			// 최소 길이 계산
			minLength = Math.min(minLength, sb.length());
		}
		return minLength;
	}
}
