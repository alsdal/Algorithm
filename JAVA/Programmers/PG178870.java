/*
문제 : 연속된 부분 수열의 합
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178870
*/

public class PG178870 {
	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 4, 5 }, 7);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(new int[] { 1, 1, 1, 2, 3, 4, 5 }, 5);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(new int[] { 2, 2, 2, 2, 2 }, 6);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int[] sequence, int k) {
		int left = 0;
		int sum = 0;

		int bestLeft = 0;
		int bestRight = 0;
		int minLen = Integer.MAX_VALUE;

		for (int right = 0; right < sequence.length; right++) {
			sum += sequence[right];

			// 합이 k보다 크다면 왼쪽 값 제거
			while (sum > k) {
				sum -= sequence[left++];
			}

			// 합이 k라면 길이가 짧은 수열 저장
			if (sum == k) {
				int len = right - left;
				if (len < minLen) {
					minLen = len;
					bestLeft = left;
					bestRight = right;
				}
			}
		}

		return new int[] { bestLeft, bestRight };
	}
}
