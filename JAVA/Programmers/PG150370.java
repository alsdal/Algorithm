/*
문제 : 개인정보 수집 유효기간
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150370
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PG150370 {
	public static void main(String[] args) {
		int[] arr = solution("2022.05.19", new String[] { "A 6", "B 12", "C 3" },
				new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
		// 날짜 변환
		int todayDays = dateTransfer(today);

		// 약관 종류 map 변환
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < terms.length; i++) {
			StringTokenizer st = new StringTokenizer(terms[i]);
			String type = st.nextToken();
			int duration = Integer.parseInt(st.nextToken());
			map.put(type, duration);
		}

		// 유효기간 날짜 계산 후 비교
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < privacies.length; i++) {
			StringTokenizer st = new StringTokenizer(privacies[i]);
			String date = st.nextToken();
			String term = st.nextToken();

			int expireDays = dateTransfer(date) + map.get(term) * 28;
			if (expireDays <= todayDays) {
				list.add(i + 1);
			}
		}

		// 리스트 -> 배열 변환
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	// 날짜 -> 일수 변환
	public static int dateTransfer(String date) {
		StringTokenizer st = new StringTokenizer(date, ".");
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int days = y * 12 * 28 + m * 28 + d;
		return days;
	}
}
