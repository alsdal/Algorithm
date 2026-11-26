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
		// 맵기 순서로 우선순위큐 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int scale : scoville) {
			pq.offer(scale);
		}

		int cnt = 0;
		while (pq.peek() < K) {
			// 음식 모두 섞었지만 K 이상 만들 수 없는 경우
			if (pq.size() < 2) {
				return -1;
			}

			// 음식 섞고 섞은 횟수 저장
			int firstLow = pq.poll();
			int secondLow = pq.poll();
			pq.offer(firstLow + (secondLow * 2));
			cnt++;
		}

		return cnt;
	}
}
