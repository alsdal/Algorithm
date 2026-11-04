/*
문제 : 전화번호 목록
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42577
*/

import java.util.HashSet;
import java.util.Set;

public class PG42577 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "119", "97674223", "1195524421" }));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		// set에 전화번호 저장
		Set<String> set = new HashSet<>();
		for (String number : phone_book) {
			set.add(number);
		}

		// 접두어 탐색
		for (String number : phone_book) {
			for (int i = 1; i < number.length(); i++) {
				String prefix = number.substring(0, i);
				if (set.contains(prefix)) {
					answer = false;
				}
			}
		}
		return answer;
	}
}
