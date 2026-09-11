/*
문제 : 예상 대진표
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12985
*/

public class PG12985 {
	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;

		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;
		}

		return answer;
	}
}
