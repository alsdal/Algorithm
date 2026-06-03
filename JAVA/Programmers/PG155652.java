/*
문제 : 둘만의 암호
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155652
*/

public class PG155652 {
	public static void main(String[] args) {
		System.out.println(solution("aukks", "wbqd", 5));
	}

	public static String solution(String s, String skip, int index) {
		StringBuilder answer = new StringBuilder();

		for (char c : s.toCharArray()) {
			int count = 0;
			char current = c;

			while (count < index) {
				current++;

				if (current > 'z') {
					current = 'a';
				}

				if (skip.indexOf(current) == -1) {
					count++;
				}
			}
			answer.append(current);

		}

		return answer.toString();
	}
}
