/*
문제 : 디스크 컨트롤러
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42627
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG42627 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 3, 5 } }));
	}

	public static int solution(int[][] jobs) {
		// 작업 시작 시간순 정렬
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		// 작업 시간 짧은순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});

		int curTime = 0; // 현재 시간
		int idx = 0; // 작업번호 인덱스
		int returnTime = 0; // 반환 시간

		while (idx < jobs.length || !pq.isEmpty()) {
			// 현재 시간 이전에 시작하는 작업 큐에 추가
			while (idx < jobs.length && jobs[idx][0] <= curTime) {
				pq.offer(jobs[idx++]);
			}

			// 대기중인 작업 없다면 다음 작업으로 현재 시간 갱신
			if (pq.isEmpty()) {
				curTime = jobs[idx][0];
			}
			// 대기 큐에 작업 추가, 반환 시간 계산
			else {
				int[] job = pq.poll();
				curTime += job[1];
				returnTime += curTime - job[0];
			}
		}
		return returnTime / jobs.length;
	}
}
