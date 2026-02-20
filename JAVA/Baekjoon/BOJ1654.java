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
	static int K, N;
	static long maxLength = 0;
	static int[] cables;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

		cables = new int[K]; // 랜선 담을 배열
		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			maxLength = Math.max(maxLength, cables[i]);
		}

		System.out.println(binary(cables));
	}

	public static long binary(int[] cables) {
	    long s = 1;
	    long e = maxLength + 1;

	    while (s < e) { // 랜선의 길이로 이분탐색
	        long m = (s + e) / 2;
	        long cnt = 0; // 랜선의 개수
	        
	        for (int i = 0; i < K; i++) { // 랜선의 개수 구하기
	            cnt += cables[i] / m;
	        }

	        // 길이 조정(upper bound)
	        if (cnt < N) {
	            e = m;
	        } else {
	            s = m + 1;
	        }
	    }
	    return s-1;
	}
}
