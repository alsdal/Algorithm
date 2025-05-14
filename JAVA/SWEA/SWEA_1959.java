import java.io.FileInputStream;
import java.util.Scanner;

// #1959. 두 개의 숫자열
public class SWEA_1959 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input1959.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

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
			System.out.printf("#%d %d\n", test_case, maxSum);
		}
	}
}
