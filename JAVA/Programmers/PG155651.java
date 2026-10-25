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
		int[][] book_minutes = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			book_minutes[i][0] = toMinutes(book_time[i][0]);
			book_minutes[i][1] = toMinutes(book_time[i][1]) + 10;
		}

		// 입실 시간 기준 정렬
		Arrays.sort(book_minutes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] booking : book_minutes) {
			int start = booking[0];
			int end = booking[1];

			// 방 재사용
			if (!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}

			// 배정된 방 끝나는 시간 저장
			pq.offer(end);
		}
		return pq.size();
	}

	public static int toMinutes(String time) {
		String[] hhmm = time.split(":");

		int h = Integer.parseInt(hhmm[0]);
		int m = Integer.parseInt(hhmm[1]);

		return h * 60 + m;
	}
}
