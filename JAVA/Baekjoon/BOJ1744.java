/*
문제 : 수 묶기
유형 : 그리디
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1744
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1744 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		PriorityQueue<Integer> posQ = new PriorityQueue<>(Collections.reverseOrder()); // 양수 큐
		PriorityQueue<Integer> negQ = new PriorityQueue<>(); // 음수 큐
		boolean hasZero = false;
		int sum = 0;

		// 수열 입력
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num < 0) {
				negQ.add(num);
			} else if (num > 1) {
				posQ.add(num);
			} else if (num == 1) {
				sum++;
			} else if (num == 0) {
				hasZero = true;
			}
		}

		// 양수 큐 계산
		while (posQ.size() > 1) {
			int x = posQ.poll();
			int y = posQ.poll();
			sum += (x * y);
		}
		if (!posQ.isEmpty()) {
			sum += posQ.poll();
		}

		// 음수 큐 계산
		while (negQ.size() > 1) {
			int x = negQ.poll();
			int y = negQ.poll();
			sum += (x * y);
		}
		// 0이 없을 경우에만
		if (!negQ.isEmpty()) {
			if (!hasZero) {
				sum += negQ.poll();
			}
		}
		System.out.println(sum);
	}
}
