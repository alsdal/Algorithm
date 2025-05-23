import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
 
class SWEA_12712
{
	public static void main(String args[]) throws Exception
	{
	System.setIn(new FileInputStream("in1.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int maxFly = 0;			
			// 3*N x 3*N 크기 배열 선언
			int arr[][] = new int[3*N][3*N];
			// 가운데에 N*N 파리 개체수 배열 입력
			for(int i = N; i < 2*N; i++) {
				for(int j = N; j < 2*N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = N; i<2*N; i++) {
				for(int j = N; j<2*N; j++) {
					int sum=0;
					// +형 분사
					for(int k = -M+1; k<=M-1; k++) {
						sum += arr[i][j+k];
						sum += arr[i+k][j];
					}
					sum -= arr[i][j];
					maxFly = Math.max(maxFly, sum);
					sum = 0;
					// x형 분사
					for(int k = -M+1; k<=M-1; k++) {
						sum += arr[i+k][j+k];
						sum += arr[i-k][j+k];
					}
					sum -= arr[i][j];
					maxFly = Math.max(maxFly, sum);
				}
			}
			System.out.println("#"+test_case+" "+maxFly);
		}
	}
}
