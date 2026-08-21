/*
문제 : 카드 뭉치
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159994
*/

public class PG159994 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "i", "drink", "water" }, new String[] { "want", "to" },
				new String[] { "i", "want", "to", "drink", "water" }));
	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		int idx1 = 0;
		int idx2 = 0;

		for (String word : goal) {
			if (idx1 < cards1.length && word.equals(cards1[idx1])) {
				idx1++;
			} else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
				idx2++;
			} else {
				return "No";
			}
		}

		return "Yes";
	}
}
