/*
문제 : 크기가 작은 부분 문자열
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/147355
*/

public class PG147355 {
	public static void main(String[] args) {
		System.out.println(solution("3141592", "271"));
	}

	public static int solution(String t, String p) {
		int answer = 0;
		int len = p.length();

		for (int i = 0; i <= t.length() - len; i++) {
			String s = t.substring(i, i + len);
			long num = Long.parseLong(s);
			if (num <= Long.parseLong(p)) {
				answer++;
			}
		}

		return answer;
	}
}