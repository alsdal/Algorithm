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
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int time = 0; // 현재 시간
		int idx = 0; // 작업번호 인덱스
		int sum = 0; // 작업 시간 합

		while (idx < jobs.length || !pq.isEmpty()) {
			// 현재 시간보다 이전에 시작하는 작업 모두 큐에 추가
			while (idx < jobs.length && jobs[idx][0] <= time) {
				pq.offer(jobs[idx++]);
			}

			// 작업이 끝나는 시간으로 시간 갱신
			if (pq.isEmpty()) {
				time = jobs[idx][0];
			} else {
				int[] job = pq.poll();
				time += job[1];
				sum += time - job[0];
			}
		}
		return sum / jobs.length;
	}
}
