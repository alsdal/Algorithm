/*
문제 : 이중우선순위큐
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42628
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class PG42628 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" });
		for (int i : arr) {
			System.out.println(i);
		}
		int[] arr2 = solution(
				new String[] { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" });
		for (int i : arr2) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

		for (String s : operations) {
			String[] str = s.split(" ");
			String cmd = str[0];
			int num = Integer.parseInt(str[1]);

			// 삽입
			if (cmd.equals("I")) {
				minPQ.offer(num);
				maxPQ.offer(num);
			}
			// 삭제
			else {
				if (minPQ.isEmpty()) {
					continue;
				}

				// 최댓값 삭제
				if (num == 1) {
					int max = maxPQ.poll();
					minPQ.remove(max);
				}
				// 최솟값 삭제
				else {
					int min = minPQ.poll();
					maxPQ.remove(min);
				}
			}
		}
		// 결과 저장
		if (minPQ.isEmpty()) {
			return new int[] { 0, 0 };
		}
		return new int[] { maxPQ.peek(), minPQ.peek() };
	}
}
