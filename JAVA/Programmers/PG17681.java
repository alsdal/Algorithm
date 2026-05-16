/*
문제 : 비밀지도
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */

public class PG17681 {
	public static void main(String[] args) {
//		String[] string = solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
		String[] string = solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });

		for (int i = 0; i < string.length; i++) {
			System.out.println(string[i]);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			int num = arr1[i] | arr2[i];

			String binary = Integer.toBinaryString(num);
			binary = String.format("%" + n + "s", binary).replace(" ", "0");
			binary = binary.replace("1", "#");
			binary = binary.replace("0", " ");

			answer[i] = binary;
		}
		return answer;
	}
}