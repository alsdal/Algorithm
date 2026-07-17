/*
문제 : 호텔 대실
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG155651 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" },
				{ "14:10", "19:20" }, { "18:20", "21:20" } }));
	}

	public static int solution(String[][] book_time) {
		int answer = 0;

		// 예약 시각 int 분 단위로 변환
		int[][] times = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			times[i][0] = toMinute(book_time[i][0]);
			times[i][1] = toMinute(book_time[i][1]) + 10;
		}

		// 입실 시간 순 정렬
		Arrays.sort(times, (a, b) -> a[0] - b[0]);

		// 방이 비는 시간 저장하여 방 개수 세기
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int time[] : times) {
			if (!pq.isEmpty() && pq.peek() <= time[0]) {
				pq.poll();
			}
			pq.offer(time[1]);
		}
		return pq.size();
	}

	public static int toMinute(String s) {
		String[] t = s.split(":");
		int h = Integer.parseInt(t[0]);
		int m = Integer.parseInt(t[1]);
		return h * 60 + m;
	}
}
