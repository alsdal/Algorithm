/*
문제 : 가장 큰 수
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42746
*/

import java.util.Arrays;
import java.util.Comparator;

public class PG42746 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}

	public static String solution(int[] numbers) {
		String[] nums = new String[numbers.length];

		// int -> String 변환
		for (int i = 0; i < numbers.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}

		// 두 개의 정수 이어붙였을 때 큰 순서로 정렬
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		// 정수 이어 붙이기
		StringBuilder sb = new StringBuilder();
		for (String num : nums) {
			sb.append(num);
		}

		// 모든 정수가 0인 경우 예외 처리
		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}
}
