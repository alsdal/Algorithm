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
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken()); // 숫자 카드 입력
		}

		Arrays.sort(cards); // 숫자 카드 정렬

		int M = Integer.parseInt(br.readLine()); // 구해야 할 카드 수
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(upperBound(cards, num) - lowerBound(cards, num)).append(" "); // 양쪽 경계값 이분 탐색하여 개수 계산
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
