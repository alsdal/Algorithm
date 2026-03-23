/*
문제 : K번째 수
유형 : 정렬
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/11004
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N개의 수
		int K = Integer.parseInt(st.nextToken()); // 앞에서 K번째 수

		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(A, 0, N - 1, K - 1); // 퀵 정렬 수행(K번째까지만)
		System.out.println(A[K - 1]);
	}

	static void quickSort(int[] A, int s, int e, int k) {
		if (s < e) {
			int pivot = partition(A, s, e);
			// pivot의 위치가 k인 경우 종료
			if (pivot == k)
				return;
			// k가 pivot의 위치보다 왼쪽에 있는 경우
			else if (k < pivot)
				quickSort(A, s, pivot - 1, k);
			// k가 pivot의 위치보다 오른쪽에 있는 경우
			else
				quickSort(A, pivot + 1, e, k);
		}
	}

	static int partition(int[] A, int s, int e) {
		// 원소가 2개인 경우 간단히 처리
		if (s + 1 == e) {
			if (A[s] > A[e])
				swap(A, s, e);
			return e;
		}
		
		// 중간값을 pivot으로 설정하고 맨앞으로 자리 옮김
		int m = (s + e) / 2;
		swap(A, s, m);
		int pivot = A[s];
		
		int i = s + 1;
		int j = e;
		// pivot 기준으로 왼쪽 오른쪽 구분
		while (i <= j) {
			// pivot보다 큰 값 찾기
			while (j >= s + 1 && pivot < A[j]) {
				j--;
			}
			// pivot보다 작은 값 찾기
			while (i <= e && pivot > A[i]) {
				i++;
			}
			//잘못된 위치의 값 swap
			if (i <= j) {
				swap(A, i++, j--);
			}
		}

		// pivot 위치 확정 반환
		A[s] = A[j];
		A[j] = pivot;
		return j;
	}

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
