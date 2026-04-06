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
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		st = new StringTokenizer(br.readLine()); // 숫자 카드에 적힌 수
		cards = new int[N];

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine()); // 구할 숫자 카드 개수
		st = new StringTokenizer(br.readLine()); // 구할 숫자 카드

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = cards.length - 1;

			boolean hasCard = false;
			while (s <= e) {
				int m = (s + e) / 2;

				if (cards[m] < num) {
					s = m + 1;
				} else if (cards[m] > num) {
					e = m - 1;
				} else {
					hasCard = true;
					break;
				}
			}
			
			if(hasCard) {
				sb.append(1 + " ");
			}
			else {
				sb.append(0 + " ");
			}

		}
		System.out.println(sb);
	}
}
