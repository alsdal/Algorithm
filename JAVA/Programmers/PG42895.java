/*
문제 : N으로 표현
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42895
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PG42895 {
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
	}

	public static int solution(int N, int number) {
		List<Set<Integer>> dp = new ArrayList<>();
		for (int i = 0; i <= 8; i++) {
			dp.add(new HashSet<>());
		}

		int repeated = 0;
		for (int i = 1; i <= 8; i++) {
			repeated = repeated * 10 + N;
			dp.get(i).add(repeated);

			for (int j = 1; j < i; j++) {
				for (int a : dp.get(j)) {
					for (int b : dp.get(i - j)) {
						dp.get(i).add(a + b);
						dp.get(i).add(a - b);
						dp.get(i).add(a * b);

						if (b != 0) {
							dp.get(i).add(a / b);
						}
					}
				}
			}

			if (dp.get(i).contains(number)) {
				return i;
			}
		}

		return -1;
	}
}
