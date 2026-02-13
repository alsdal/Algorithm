/*
문제 : 통계학
유형 : 수학, 구현, 정렬
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/2108
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] arr = new int[N]; // 입력 받은 정수
		int[] count = new int[8001]; // 카운팅 배열
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			count[arr[i] + 4000]++;
		}

		Arrays.sort(arr);
		
		int mode = 0; // 최빈값
		int max = 0; // 최대 개수 구하기
		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);			
		}

		// 두번째로 작은 최빈값 구하기
		boolean hasSecond = false;
		for (int i = 0; i < count.length; i++) {
			if(count[i] == max) {
				if(!hasSecond) {
					mode = i - 4000;
					hasSecond = true;
				}
				else {
					mode = i - 4000;
					break;
				}
			}
		}

		System.out.println((int) Math.round((double)sum / N)); // 산술평균
		System.out.println(arr[N / 2]); // 중앙값
		System.out.println(mode); // 최빈값
		System.out.println(arr[N - 1] - arr[0]); // 범위
	}
}
