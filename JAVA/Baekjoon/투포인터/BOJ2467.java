package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {
	static int[] arr, ans;
	static int N, minDiff;
	static int ans1, ans2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 전체 용액 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int s = 0; // 시작 포인터 
		int e = N - 1; // 끝 포인터
		ans = new int[2]; // 결과값 저장할 배열
		minDiff = Integer.MAX_VALUE; // 최소 차이
		
		// 양쪽 포인터 만날 때까지
		while (s < e) {
			// 합의 차이가 더 작다면 최소 차이 갱신, 두 용액 저장
			int sum = arr[s] + arr[e];
			int absSum = Math.abs(sum);
			
			if(absSum < minDiff) {
				minDiff = absSum;
				ans1 = arr[s];
				ans2 = arr[e];
			}
			
			// 포인터 조정
			if(sum < 0) {
				s++;
			}
			else {
				e--;
			}
		}
		// 결과 출력
		sb.append(ans1).append(" ").append(ans2);
		System.out.print(sb);
	}
}
