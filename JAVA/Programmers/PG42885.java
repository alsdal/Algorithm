/*
문제 : 구명보트
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42885
*/

import java.util.Arrays;

public class PG42885 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100));
		System.out.println(solution(new int[] { 70, 80, 50 }, 100));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;

		int left = 0;
		int right = people.length - 1;

		Arrays.sort(people);

		while (left <= right) {
			if (people[left] + people[right] <= limit) {
				left++;
			}
			answer++;
			right--;
		}
		return answer;
	}
}