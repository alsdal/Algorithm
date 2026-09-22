/*
문제 : 캐시
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17680
*/

import java.util.ArrayList;
import java.util.List;

public class PG17680 {
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA" }));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		List<String> list = new ArrayList<>();

		// 캐시 크기 0인 경우 예외 처리
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (String city : cities) {
			city = city.toLowerCase();

			// cache hit
			if (list.contains(city)) {
				answer += 1;
				list.remove(city);
			}
			// cache miss
			else {
				answer += 5;
				if (list.size() == cacheSize) {
					list.remove(0);
				}
			}

			list.add(city);
		}

		return answer;
	}
}
