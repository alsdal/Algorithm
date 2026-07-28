/*
문제 : 카펫
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42842
*/

public class PG42842 {
	public static void main(String[] args) {
		int[] arr = solution(10, 2);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(8, 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(24, 24);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int brown, int yellow) {
		int total = brown + yellow;

		for (int h = 3; h * h <= total; h++) {
			if (total % h != 0) {
				continue;
			}

			int w = total / h;
			if ((w - 2) * (h - 2) == yellow) {
				return new int[] { w, h };
			}
		}

		return null;
	}
}
