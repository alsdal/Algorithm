/*
문제 : 두 큐 합 같게 만들기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118667
*/

import java.util.LinkedList;
import java.util.Queue;

public class PG118667 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 2, 7, 2 }, new int[] { 4, 6, 5, 1 }));
		System.out.println(solution(new int[] { 1, 2, 1, 2 }, new int[] { 1, 10, 1, 2 }));
		System.out.println(solution(new int[] { 1, 1 }, new int[] { 1, 5 }));
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		// 큐에 추가하고 합 구하기
		long sum1 = 0;
		long sum2 = 0;
		for (int n : queue1) {
			q1.offer(n);
			sum1 += n;
		}
		for (int n : queue2) {
			q2.offer(n);
			sum2 += n;
		}

		// 총합이 홀수이면 불가능
		if (((sum1 + sum2) % 2) == 1) {
			return -1;
		}

		int limit = q1.size() * 4;

		// 숫자 이동하기
		while (answer <= limit) {
			if (sum1 == sum2) {
				return answer;
			} else if (sum1 > sum2) {
				int num = q1.poll();
				q2.offer(num);
				sum1 -= num;
				sum2 += num;
			} else {
				int num = q2.poll();
				q1.offer(num);
				sum2 -= num;
				sum1 += num;
			}
			answer++;
		}

		return -1;
	}
}
