/*
문제 : 프로세스
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
*/

import java.util.*;

public class PG42587 {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(i);
		}

		int cnt = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			boolean hasHigher = false;

			// 대기중인 우선순위가 높은 프로세스 확인
			for (int idx : queue) {
				if (priorities[idx] > priorities[cur]) {
					hasHigher = true;
					break;
				}
			}

			// 높은 프로세스 있다면 현재 프로세스 큐 뒤에 넣기
			if (hasHigher) {
				queue.offer(cur);
				continue;
			}

			cnt++;

			if (cur == location) {
				return cnt;
			}

		}

		return -1;
	}
}
