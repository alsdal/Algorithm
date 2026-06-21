/*
문제 : 방문 길이
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
*/

import java.util.HashSet;
import java.util.Set;

public class PG49994 {
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
	}

	public static int solution(String dirs) {
		int answer = 0;
		int x = 0;
		int y = 0;

		Set<String> set = new HashSet<>();

		for (char c : dirs.toCharArray()) {
			int nx = x;
			int ny = y;

			if (c == 'U')
				ny++;
			else if (c == 'D')
				ny--;
			else if (c == 'L')
				nx--;
			else if (c == 'R')
				nx++;

			if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
				continue;
			}

			String path1 = x + "," + y + "," + nx + "," + ny;
			String path2 = nx + "," + ny + "," + x + "," + y;

			if (!set.contains(path1)) {
				set.add(path1);
				set.add(path2);
				answer++;
			}

			x = nx;
			y = ny;
		}

		return answer;
	}
}
