/*
문제 : 단어 변환
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
*/

import java.util.LinkedList;
import java.util.Queue;

public class PG43163 {
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
	}

	static class Node {
		String word;
		int cnt;

		Node(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		answer = bfs(begin, target, words);

		return answer;
	}

	public static int bfs(String begin, String target, String[] words) {
		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[words.length];

		queue.offer(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.word.equals(target)) {
				return cur.cnt;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i]) {
					continue;
				}

				if (canChange(cur.word, words[i])) {
					queue.offer(new Node(words[i], cur.cnt + 1));
					visited[i] = true;
				}
			}
		}

		return 0;
	}

	public static boolean canChange(String curWord, String nextWord) {
		int n = curWord.length();
		int diff = 0;

		for (int i = 0; i < n; i++) {
			if (curWord.charAt(i) != nextWord.charAt(i)) {
				diff++;
			}

			if (diff > 1) {
				return false;
			}
		}

		return diff == 1;
	}
}
