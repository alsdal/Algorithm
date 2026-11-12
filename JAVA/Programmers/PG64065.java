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
		// 양끝 중괄호 제거, 문자열 분리
		s = s.substring(2, s.length() - 2);
		String[] str = s.split("\\},\\{");
		String[][] numbers = new String[str.length][];
		for (int i = 0; i < str.length; i++) {
			numbers[i] = str[i].split(",");
		}

		// 집합 길이순 정렬
		Arrays.sort(numbers, new Comparator<String[]>() {
			@Override
			public int compare(String[] a, String[] b) {
				return Integer.compare(a.length, b.length);
			}
		});

		int[] answer = new int[numbers.length];
		int idx = 0; // 정답 배열 인덱스
		Set<Integer> set = new HashSet<>();

		// 중복 아닌 경우 정답 배열에 추가
		for (String[] group : numbers) {
			for (String num : group) {
				int n = Integer.parseInt(num);
				if (set.add(n)) {
					answer[idx++] = n;
				}
			}
		}

		return answer;
	}
}
