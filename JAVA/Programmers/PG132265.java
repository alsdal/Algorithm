/*
문제 : 롤케이크 자르기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132265
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PG132265 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 1, 3, 1, 4, 1, 2 }));
	}

	public static int solution(int[] topping) {
		int answer = 0;

		Set<Integer> left = new HashSet<>();
		Map<Integer, Integer> right = new HashMap<>();

		// 오른쪽 토핑 개수 저장
		for (int t : topping) {
			right.put(t, right.getOrDefault(t, 0) + 1);
		}

		for (int t : topping) {
			left.add(t);
			right.put(t, right.get(t) - 1);

			if (right.get(t) == 0) {
				right.remove(t);
			}
			if (left.size() == right.size()) {
				answer++;
			}
		}

		return answer;
	}
}
