/*
문제 : 주차 요금 계산
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PG92341 {
	public static void main(String[] args) {
		int[] arr = solution(new int[] { 180, 5000, 10, 600 },
				new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
						"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] fees, String[] records) {
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> accTime = new TreeMap<>();
		List<int[]> list = new ArrayList<>();

		// 입출차 기록 입력
		for (String s : records) {
			StringTokenizer st = new StringTokenizer(s);

			String time = st.nextToken();
			int carNum = Integer.parseInt(st.nextToken());
			String type = st.nextToken();

			// 시간 변환
			String[] hm = time.split(":");
			int h = Integer.parseInt(hm[0]);
			int m = Integer.parseInt(hm[1]);
			int minutes = h * 60 + m;

			// 차량 주차 시간 입력
			if (type.equals("IN")) {
				map.put(carNum, minutes);
			} else {
				int inTime = map.remove(carNum);
				accTime.put(carNum, minutes - inTime + accTime.getOrDefault(carNum, 0));
			}

		}

		// 출차 내역 없는 차량 주차 시간 더하기
		for (int carNum : map.keySet()) {
			accTime.put(carNum, 1439 - map.get(carNum) + accTime.getOrDefault(carNum, 0));
		}

		// 주차 요금 계산
		for (int carNum : accTime.keySet()) {
			int parkTime = accTime.get(carNum);
			int fee = fees[1];
			if (parkTime > fees[0]) {
				fee += Math.ceil((double) (parkTime - fees[0]) / fees[2]) * fees[3];
			}
			list.add(new int[] { carNum, fee });
		}

		// list -> arr 변환
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i)[1];
		}

		return answer;
	}
}
