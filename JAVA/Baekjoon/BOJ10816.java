/*
문제 : 숫자 카드 2
유형 : 이분탐색, 정렬
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/10816
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
	static int[] cards;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		cards = new int[N];

		st = new StringTokenizer(br.readLine()); // 숫자 카드 입력
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards); // 카드 오름차순 정렬

		int M = Integer.parseInt(br.readLine()); // 구해야할 정수의 개수

		st = new StringTokenizer(br.readLine()); // 구해야할 정수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(upperBound(cards, num) - lowerBound(cards, num) + " ");
		}

		System.out.println(sb);
	}

	// 하한 이분탐색
	public static int lowerBound(int[] cards, int k) {
		int s = 0;
		int e = cards.length;

		while (s < e) {
			int m = (s + e) / 2;

			if (k <= cards[m]) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		return s;
	}

	// 상한 이분탐색
	public static int upperBound(int[] cards, int k) {
		int s = 0;
		int e = cards.length;

		while (s < e) {
			int m = (s + e) / 2;

			if (k < cards[m]) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		return s;
	}
}
