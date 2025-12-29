/*
문제 : View
난이도 : D3
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
class SWEA1206
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int i = 2; i < arr.length-2; i++) {
                int maxHeight = Math.max(Math.max(Math.max(arr[i-2],arr[i-1]),arr[i+1]),arr[i+2]);
                cnt += Math.max((arr[i] - maxHeight),0);
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}
