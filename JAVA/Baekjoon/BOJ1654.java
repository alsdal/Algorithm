/*
문제 : 랜선 자르기
유형 : 이분탐색
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/1654
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		int[] cables = new int[K]; // 가지고 있는 랜선
		
		int maxCable = 0;
		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			maxCable = Math.max(maxCable, cables[i]);
		}
		
		long res = 0;
		long s = 1;
		long e = maxCable;
		
		while(s <= e) {
			long m = (s + e) / 2;
			long cnt = 0; // 랜선의 개수
			for (int i = 0; i < K; i++) {
				cnt += cables[i] / m;
			}
			
			if(cnt >= N) {
				res = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		System.out.println(res);
	}
}
