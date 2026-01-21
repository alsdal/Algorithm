/*
문제 : 나머지 합 구하기
유형 : 누적합
난이도 : 골드3
링크 : https://www.acmicpc.net/problem/10986
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N];	// 누적합 배열
		long[] C = new long[M];	// 나머지별 인덱스 카운팅
		long ans = 0;
		
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken()) + S[i-1];
		}
		
		// 누적합 배열에 대해 % 연산 수행
		for (int i = 0; i < N; i++) {
			int R = (int) (S[i] % M);
			if(R == 0) ans++;
			C[R]++;
		}
		
		// 나머지 같은 인덱스 중 2개를 뽑는 경우의수 조합 연산
		for (int i = 0; i < M; i++) {
			if(C[i] > 1) ans = ans + (C[i] * (C[i]-1) / 2);
		}
		
		System.out.println(ans);
	}
}
