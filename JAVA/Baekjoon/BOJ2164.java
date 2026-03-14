/*
문제 : 카드2
유형 : 자료구조, 큐
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/2164
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			queue.poll(); // 제일 위에 있는 카드 버리기
			queue.add(queue.poll()); // 제일 위에 있는 카드 아래로 옮기기
		}
		System.out.println(queue.poll());
	}
}

/*
 * 1 2 3 4
 * 2 3 4
 * 3 4 2
 * 4 2
 * 2 4
 * 4
 */