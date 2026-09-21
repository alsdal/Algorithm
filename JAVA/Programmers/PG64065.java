/*
문제 : 튜플
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64065
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PG64065 {
	public static void main(String[] args) {
		int[] arr = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(String s) {
		// 문자열 분리
		s = s.substring(2, s.length() - 2);
		String[] groups = s.split("\\},\\{");

		// 숫자 문자열 배열로 변환
		String[][] numbers = new String[groups.length][];
		for (int i = 0; i < groups.length; i++) {
			numbers[i] = groups[i].split(",");
		}

		// 원소 개수 적은 순서로 정렬
		Arrays.sort(numbers, new Comparator<String[]>() {
			@Override
			public int compare(String[] a, String[] b) {
				return Integer.compare(a.length, b.length);
			}
		});

		int[] answer = new int[groups.length];
		int idx = 0;
		Set<Integer> set = new HashSet<>();

		for (String[] group : numbers) {
			for (String str : group) {
				int num = Integer.parseInt(str);
				// 처음 등장한 숫자이면 정답 배열에 추가
				if (set.add(num)) {
					answer[idx++] = num;
				}
			}
		}

		return answer;
	}
}
