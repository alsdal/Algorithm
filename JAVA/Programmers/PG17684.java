/*
문제 : 압축
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17684
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG17684 {
	public int[] solution(String msg) {
		Map<String, Integer> dictionary = new HashMap<>();
		List<Integer> idxList = new ArrayList<>();

		// 사전 초기화
		for (char c = 'A'; c <= 'Z'; c++) {
			dictionary.put(String.valueOf(c), c - 'A' + 1);
		}

		int i = 0;

		while (i < msg.length()) {
			String w = String.valueOf(msg.charAt(i));
			int j = i + 1;

			// 사전에 존재하는 가장 긴 문자열 찾기
			while (j < msg.length()) {
				String nw = w + String.valueOf(msg.charAt(j));
				if (!dictionary.containsKey(nw)) {
					break;
				}
				w = nw;
				j++;
			}

			// 색인 번호 추가
			idxList.add(dictionary.get(w));

			// 사전에 단어 등록
			if (j < msg.length()) {
				dictionary.put(w + String.valueOf(msg.charAt(j)), dictionary.size() + 1);
			}

			i = j;
		}

		// 정답 list -> int[] 변환
		int[] answer = new int[idxList.size()];
		for (int k = 0; k < idxList.size(); k++) {
			answer[k] = idxList.get(k);
		}

		return answer;
	}
}
