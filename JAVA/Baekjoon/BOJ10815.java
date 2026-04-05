/*
문제 : 숫자 카드
유형 : 이분탐색
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/10815
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		int[] cards = new int[N];

		st = new StringTokenizer(br.readLine()); // 숫자 카드에 적힌 정수
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine()); // 구해야할 정수 개수
		st = new StringTokenizer(br.readLine()); // 구해야하는 정수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(hasCard(cards, num)).append(" ");
		}
		System.out.println(sb);
	}

	public static int hasCard(int[] cards, int key) {
		int s = 0;
		int e = cards.length - 1;

		while (s <= e) {
			int m = (s + e) / 2;
			if (key < cards[m]) {
				e = m - 1;
			} else if (key > cards[m]) {
				s = m + 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
