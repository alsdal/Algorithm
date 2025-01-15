import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1961 {

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("in2.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case);
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int arr_90[][] = rotate(arr);
			int arr_180[][] = rotate(arr_90);
			int arr_270[][] = rotate(arr_180);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(arr_90[i][j]);
				System.out.print(" ");
				for (int j = 0; j < N; j++)
					System.out.print(arr_180[i][j]);
				System.out.print(" ");
				for (int j = 0; j < N; j++)
					System.out.print(arr_270[i][j]);
				System.out.println("");
			}
		}
	}

	private static int[][] rotate(int arr[][]) {
		int M = arr.length;
		int tmp[][] = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[M - j - 1][i];
			}
		}
		return tmp;
	}
}
