/*
문제 : 더 맵게 
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42626
*/

import java.util.PriorityQueue;

public class PG42626 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 모든 음식 스코빌 지수 우선순위큐에 추가
		for (int i : scoville) {
			pq.offer(i);
		}

		// 음식 섞기
		int answer = 0;
		while (pq.peek() < K) {
			if (pq.size() < 2) {
				return -1;
			}

			int firstLow = pq.poll();
			int secondLow = pq.poll();
			pq.offer(firstLow + (secondLow * 2));
			answer++;
		}
		return answer;
	}
}
