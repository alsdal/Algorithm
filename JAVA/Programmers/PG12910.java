/*
문제 : 나누어 떨어지는 숫자 배열
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG12910 {
	public static void main(String[] args) {
		int[] answer = solution(new int[] { 5, 6, 7, 10 }, 5);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		
		// 나누어 떨어지는 수 담기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		// 나누어 떨어지는 원소 없을 경우
		if (list.size() == 0) {
			list.add(-1);
		}

		// 리스트 -> 배열 변환
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);
		return answer;
	}
}
