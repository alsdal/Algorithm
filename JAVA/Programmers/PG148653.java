/*
문제 : 마법의 엘리베이터
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/148653
*/

public class PG148653 {
	public static void main(String[] args) {
		System.out.println(solution(16));
		System.out.println(solution(2554));
	}

	public static int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int digit = storey % 10;
			storey /= 10;

			if (digit < 5) {
				answer += digit;
			} else if (digit > 5) {
				answer += 10 - digit;
				storey++;
			} else { // digit == 5
				if (storey % 10 >= 5) {
					answer += 5;
					storey++;
				} else {
					answer += 5;
				}
			}
		}

		return answer;
	}
}
