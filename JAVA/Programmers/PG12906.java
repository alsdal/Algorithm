/*
문제 : 같은 숫자는 싫어
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG12906 {
	public static void main(String[] args) {
		int[] answer = solution(new int[] { 1, 1, 3, 3, 0, 1, 1 });
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);

		// 연속된 숫자 제외
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				list.add(arr[i]);
			}
		}

		// list -> array 변환
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
