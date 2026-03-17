/*
문제 : 절댓값 힙
유형 : 자료구조, 우선순위큐
난이도 : 실버1
링크 : https://www.acmicpc.net/problem/11286
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
		    if (Math.abs(a) == Math.abs(b)) {
		        return a - b;
		    }
		    return Math.abs(a) - Math.abs(b);
		});

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input != 0) { // 값 추가
				queue.add(input);
			} else { // 절댓값 가장 작은 값 출력
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			}
		}
	}
}

/*
 		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 == abs2) {
				return o1 > o2 ? 1 : -1;
			} else {
				return abs1 - abs2;
			}
		});
*/
