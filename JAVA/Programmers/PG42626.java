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

		// 맵기 낮은 순서로 정렬
		for (int i : scoville) {
			pq.offer(i);
		}

		int answer = 0;

		while (pq.peek() < K) {
			// 모두 섞었지만 K이상 만들 수 없는 경우
			if (pq.size() < 2) {
				return -1;
			}
			// 첫번째 두번째 음식 섞기
			int firstLow = pq.poll();
			int secondLow = pq.poll();
			pq.offer(firstLow + (secondLow * 2));

			// 섞은 횟수 추가
			answer++;
		}

		return answer;
	}
}
