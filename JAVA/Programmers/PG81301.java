/*
문제 : 숫자 문자열과 영단어
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */

public class PG81301 {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}

	public static int solution(String s) {
		String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int i = 0; i < numbers.length; i++) {
			s = s.replace(numbers[i], Integer.toString(i));
		}
		return Integer.parseInt(s);
	}
}
