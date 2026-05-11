/*
문제 : 다트 게임
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17682
 */

import java.util.*;

public class PG17682 {
	public static void main(String args[]) {
		System.out.println(solution("1S2D*3T"));
	}

	public static int solution(String dartResult) {
		List<Integer> scores = new ArrayList<>();

		int score = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			// 숫자
			if (Character.isDigit(c)) {
				// 10 처리
				if (c == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
					score = 10;
					i++;
				} else {
					score = c - '0';
				}

			}

			// 보너스
			else if (c == 'S' || c == 'D' || c == 'T') {
				if (c == 'S') {
					score = (int) Math.pow(score, 1);
				} else if (c == 'D') {
					score = (int) Math.pow(score, 2);
				} else if (c == 'T') {
					score = (int) Math.pow(score, 3);
				}
				scores.add(score);
			}

			// 옵션
			else if (c == '*' || c == '#') {
				int last = scores.size() - 1;
				if (c == '*') {
					scores.set(last, scores.get(last) * 2);

					if (last > 0) {
						scores.set(last - 1, scores.get(last - 1) * 2);
					}
				} else if (c == '#') {
					scores.set(last, scores.get(last) * -1);
				}
			}
		}

		int answer = 0;

		for (int i : scores) {
			answer += i;
		}
		return answer;
	}
}
