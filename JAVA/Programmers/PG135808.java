import java.util.Arrays;

public class PG135808 {
	public static void main(String[] args) {
		System.out.println(solution(3, 4, new int[] { 1, 2, 3, 1, 2, 3, 1 }));
	}

	public static int solution(int k, int m, int[] score) {
		int answer = 0;

		// 오름차순 정렬
		Arrays.sort(score);

		// 역순으로 계산
		for (int i = score.length - m; i >= 0; i -= m) {
			answer += score[i] * m;
		}

		return answer;
	}
}
