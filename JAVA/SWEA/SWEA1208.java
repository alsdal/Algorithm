/*
문제 : Flatten
난이도 : D3
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int	dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[100];
			int diff = 0;
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			diff = arr[99]-arr[0];		

			System.out.println("#"+test_case+" "+diff);
		}
	}
}
