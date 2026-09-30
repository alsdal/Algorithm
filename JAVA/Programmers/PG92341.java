/*
문제 : 주차 요금 계산
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
*/

import java.util.HashMap;
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
		Map<Integer, Integer> entranceTime = new HashMap<>();
		Map<Integer, Integer> accTime = new TreeMap<>();

		for (String record : records) {
			StringTokenizer st = new StringTokenizer(record);

			// 주차 내역 입력
			String time = st.nextToken();
			int carNum = Integer.parseInt(st.nextToken());
			String type = st.nextToken();

			// 입차시 기록 입력, 출차시 누적 주차 시간 계산
			if (type.equals("IN")) {
				entranceTime.put(carNum, convertTime(time));
			} else {
				int inTime = entranceTime.remove(carNum);
				int outTime = convertTime(time);
				accTime.put(carNum, accTime.getOrDefault(carNum, 0) + outTime - inTime);
			}
		}

		// 주차장에 남아있는 차량 시간 계산
		for (int carNum : entranceTime.keySet()) {
			accTime.put(carNum, accTime.getOrDefault(carNum, 0) + 1439 - entranceTime.get(carNum));
		}

		// 요금 계산
		int[] answer = new int[accTime.size()];
		int idx = 0;
		for (int carNum : accTime.keySet()) {
			answer[idx++] = calFee(accTime.get(carNum), fees);
		}

		return answer;
	}

	public static int convertTime(String t) {
		String[] hhmm = t.split(":");
		int h = Integer.parseInt(hhmm[0]);
		int m = Integer.parseInt(hhmm[1]);
		return h * 60 + m;
	}

	public static int calFee(int t, int[] fees) {
		if (t <= fees[0]) {
			return fees[1];
		} else {
			return fees[1] + (int) Math.ceil((double) (t - fees[0]) / fees[2]) * fees[3];
		}
	}
}
