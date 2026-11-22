/*
문제 : 호텔 대실
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG155651 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" },
				{ "14:10", "19:20" }, { "18:20", "21:20" } }));
	}

	public static int solution(String[][] book_time) {
		int[][] bookings = new int[book_time.length][2];

		// 시간 String -> int 변환
		for (int i = 0; i < book_time.length; i++) {
			bookings[i][0] = toMinutes(book_time[i][0]);
			bookings[i][1] = toMinutes(book_time[i][1]) + 10;
		}

		// 시작 시간 순 정렬
		Arrays.sort(bookings, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		// 방별 퇴실 시간 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int booking[] : bookings) {
			int start = booking[0];
			int end = booking[1];

			// 방 재사용 가능
			if (!pq.isEmpty()) {
				if (pq.peek() <= start) {
					pq.poll();
				}
			}
			// 방 추가
			pq.offer(end);
		}
		return pq.size();
	}

	public static int toMinutes(String time) {
		// 시간 파싱
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}
}
