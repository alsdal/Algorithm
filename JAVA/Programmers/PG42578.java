/*
문제 : 의상
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
*/

import java.util.HashMap;
import java.util.Map;

public class PG42578 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } }));
	}

	public static int solution(String[][] clothes) {		
		Map<String, Integer> map = new HashMap<>();
	
		// 종류별로 옷 개수 저장
		for (String[] cloth : clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}
		
		int answer = 1;
		
		for (int cnt : map.values()) {
			answer *= (cnt + 1);
		}
		
		return answer - 1;
	}
}
