/*
문제 : 두 개의 숫자열
난이도 : D2
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpoFaAS4DFAUq
*/

import java.util.Scanner;

public class SWEA1959 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int A[] = new int[N];
			int B[] = new int[M];
			int maxSum = 0;

			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();

			if (N < M) {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[j + i];
					}
					if (sum > maxSum)
						maxSum = sum;
				}
			} else {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += A[j + i] * B[j];
					}
					if (sum > maxSum)
						maxSum = sum;
				}
			}
			System.out.println("#" + test_case + " " + maxSum);
		}
	}
}
