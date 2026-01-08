/*
문제 : K번째 수
유형 : 이분탐색
난이도 : 골드1
링크 : https://www.acmicpc.net/problem/1300
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int start = 1;
		int end = k;
		int ans = 0;

		// 이분탐색
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			
			// mid 보다 작은 수의 개수 구하기
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid/i, N);
			}
			
			// 인덱스 조정
			if(cnt < k) {
				start = mid + 1;
			}
			else {
				ans = mid;
				end = mid - 1;
			}	
		}
		System.out.println(ans);
	}
}
