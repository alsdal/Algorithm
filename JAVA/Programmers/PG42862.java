import java.util.Arrays;
/*
문제 : 체육복
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */

public class PG42862 {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 }));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					answer++;
				}

			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] == -1)
				continue;
			for (int j = 0; j < reserve.length; j++) {
				if (reserve[j] == -1)
					continue;
				if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
					answer++;
					reserve[j] = -1;
					break;
				}
			}
		}
		return answer;
	}
	
	public static int solution2(int n, int[] lost, int[] reserve) {
	    int[] clothes = new int[n + 2];
	    Arrays.fill(clothes, 1);
	    for (int l : lost) clothes[l]--;
	    for (int r : reserve) clothes[r]++;

	    for (int i = 1; i <= n; i++) {
	        if (clothes[i] == 0) {
	            if (clothes[i - 1] == 2) { clothes[i - 1]--; clothes[i]++; }
	            else if (clothes[i + 1] == 2) { clothes[i + 1]--; clothes[i]++; }
	        }
	    }

	    int answer = 0;
	    for (int i = 1; i <= n; i++) if (clothes[i] >= 1) answer++;
	    return answer;
	}
}



