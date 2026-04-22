/*
문제 : 카드 정렬하기
유형 : 그리디
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/1715
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 카드 묶음의 수
		PriorityQueue<Integer> cards = new PriorityQueue<>();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			cards.add(Integer.parseInt(br.readLine()));
		}

		while (cards.size() > 1) {
			int a = cards.poll();
			int b = cards.poll();
			cards.add(a + b);
			sum += a + b;
		}
		System.out.println(sum);
	}
}
