/*
문제 : 평균 구하기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */

public class PG12944 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
	}

	public static double solution(int[] arr) {
		double answer = 0;
		
		for (int i : arr) {
			answer += i;
		}
		answer /= arr.length;
		return answer;
	}

}
