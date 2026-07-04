/*
문제 : 폰켓몬
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
*/

import java.util.HashSet;
import java.util.Set;

public class PG1845 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 3 }));
	}

	public static int solution(int[] nums) {
		int answer = 0;

		int N = nums.length;
		Set<Integer> set = new HashSet<>();

		// 번호 추가
		for (int num : nums) {
			set.add(num);
		}

		// 최대 고를 수 있는 번호 개수
		answer = Math.min(set.size(), N / 2);
		
		return answer;
	}
}
