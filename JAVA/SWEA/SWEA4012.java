/*
문제 : 요리사
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012 {

    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            selected = new boolean[N];
            answer = Integer.MAX_VALUE;

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0,0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void comb(int idx, int cnt){

        if(cnt == N/2){
            calc();
            return;
        }

        for(int i=idx;i<N;i++){
            selected[i] = true;
            comb(i+1, cnt+1);
            selected[i] = false;
        }
    }

    static void calc(){

        int A = 0;
        int B = 0;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){

                if(selected[i] && selected[j]){
                    A += S[i][j] + S[j][i];
                }

                else if(!selected[i] && !selected[j]){
                    B += S[i][j] + S[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(A-B));
    }
}