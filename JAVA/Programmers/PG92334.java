/*
문제 : 신고 결과 받기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92334
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class PG92334 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "muzi", "frodo", "apeach", "neo" },
				new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		// 이름 -> 인덱스 저장
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], i);
		}

		// 신고당한 횟수
		int[] reportCnt = new int[id_list.length];

		// 신고한 유저 목록
		List<Integer>[] reportList = new ArrayList[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			reportList[i] = new ArrayList<>();
		}

		// 신고 처리
		Set<String> set = new HashSet<>();
		for (String s : report) {
			// 중복 제거
			if (!set.add(s)) {
				continue;
			}

			StringTokenizer st = new StringTokenizer(s);
			String from = st.nextToken();
			String to = st.nextToken();
			int fromIdx = map.get(from);
			int toIdx = map.get(to);

			reportList[fromIdx].add(toIdx);
			reportCnt[toIdx]++;
		}

		// 메일 받은 횟수 계산
		int[] answer = new int[id_list.length];
		for (int i = 0; i < reportList.length; i++) {
			for (int id : reportList[i]) {
				if (reportCnt[id] >= k) {
					answer[i]++;
				}
			}
		}
		return answer;
	}
}
