/*
문제 : 괄호 변환
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60058
*/

public class PG60058 {
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
	}

	public static String solution(String p) {
		// 1. 입력이 빈 문자열인 경우
		if (p.isEmpty()) {
			return "";
		}

		int cnt = 0;
		int idx = 0;

		// 2. 가장 짧은 균형잡힌 문자열 u의 위치 끝 찾아서 분리
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}

			if (cnt == 0) {
				idx = i + 1;
				break;
			}
		}

		String u = p.substring(0, idx);
		String v = p.substring(idx);

		// 3. u가 올바른 괄호 문자열인 경우
		if (isCorrect(u)) {
			return u + solution(v);
		}

		// 4. u가 올바른 괄호 문자열이 아닌 경우
		StringBuilder sb = new StringBuilder();

		sb.append('(');
		sb.append(solution(v));
		sb.append(')');

		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				sb.append(')');
			} else {
				sb.append('(');
			}
		}

		return sb.toString();
	}

	// 올바른 괄호 문자열 판별
	public static boolean isCorrect(String s) {
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}

			// 닫는 괄호가 여는 괄호보다 먼저 나온 경우
			if (cnt < 0) {
				return false;
			}
		}

		return cnt == 0;
	}
}
