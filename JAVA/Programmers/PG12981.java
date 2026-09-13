/*
문제 : 영어 끝말잇기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12981
*/

import java.util.HashSet;
import java.util.Set;

public class PG12981 {
	public static void main(String[] args) {
		int[] arr = solution(3,
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int n, String[] words) {
		Set<String> set = new HashSet<>();
		set.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			int person = (i % n) + 1;
			int turn = (i / n) + 1;

			if (set.contains(words[i])) {
				return new int[] { person, turn };
			}

			if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				return new int[] { person, turn };
			}

			set.add(words[i]);
		}

		return new int[] { 0, 0 };
	}
}
