/*
문제 : 스킬트리
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49993
*/

public class PG49993 {
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skillTree : skill_trees) {
			int idx = 0;
			boolean possible = true;
			
			for (int i = 0; i < skillTree.length(); i++) {
				char cur = skillTree.charAt(i);

				// 선행스킬 없는 경우
				if (skill.indexOf(cur) == -1) {
					continue;
				}

				// 선행스킬 충족하지 않는 경우
				if (skill.charAt(idx) != cur) {
					possible = false;
					break;
				}

				// 선행스킬 충족
				idx++;
			}

			if (possible) {
				answer++;
			}
		}

		return answer;
	}
}
