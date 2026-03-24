/*
문제 : 수 정렬하기2
유형 : 정렬
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/2751
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2751 {
	public static int[] A, tmp;
	public static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(0, N - 1);

		for (int i = 0; i < N; i++) {
			sb.append(A[i] + "\n");
		}
		System.out.println(sb);
	}

	public static void mergeSort(int s, int e) {
		// 원소가 한 개일 경우 예외처리
		if (e - s < 1) {
			return;
		}
		
		int m = (s + e)/ 2;
		
		// 왼쪽 정렬
		mergeSort(s, m);
		// 오른쪽 정렬
		mergeSort(m + 1, e);
		// 병합
		merge(s, m, e);
	}
	
	public static void merge(int s, int m, int e) {
		int i = s;	// 왼쪽 배열 인덱스
		int j = m + 1; // 오른쪽 배열 인덱스
		int k = s;	// tmp배열 인덱스
		
		// tmp 배열에 오름차순으로 저장
		while(i <= m && j <= e) {
			if(A[i] <= A[j]) {
				tmp[k++] = A[i++];
			} else {
				tmp[k++] = A[j++];
			}
		}
		
		// 배열에 남아있는 값 복사
		while(i <= m) {
			tmp[k++] = A[i++];
		}
		while(j <= e) {
			tmp[k++] = A[j++];
		}
		
		// tmp 배열 복사
		for (int t = s; t <= e; t++) {
			A[t] = tmp[t];
		}
		
	}
}
