/*
문제 : 프로세스
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
*/

import java.util.*;

public class PG42587 {
	public int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(i);
		}

		int order = 0;

		while (!queue.isEmpty()) {
			int curIdx = queue.poll();
			int priority = priorities[curIdx];
			boolean hasHigher = false;

			// 현재 프로세스보다 높은 프로세스 있는지 확인
			for (int idx : queue) {
				if (priority < priorities[idx]) {
					hasHigher = true;
					break;
				}
			}

			// 현재 프로세스의 우선순위가 낮은 경우 큐에 다시 넣기
			if (hasHigher) {
				queue.offer(curIdx);
			}
			// 현재 프로세스 실행
			else {
				order++;
				// 실행된 프로세스가 구하고자 하는 프로세스인 경우
				if (curIdx == location) {
					return order;
				}
			}
		}

		return -1;
	}
}
