/*
문제 : 베스트앨범
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42579
*/

import java.util.*;

public class PG42579 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 });

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] genres, int[] plays) {
		int n = genres.length;

		Map<String, Integer> genrePlays = new HashMap<>();
		Map<String, List<Integer>> genreSongs = new HashMap<>();

		// 장르별 총 재생 수, 장르별 곡 고유 번호 저장
		for (int i = 0; i < n; i++) {
			genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);

			if (!genreSongs.containsKey(genres[i])) {
				genreSongs.put(genres[i], new ArrayList<>());
			}
			genreSongs.get(genres[i]).add(i);
		}

		// 재생 수 기준 장르 정렬
		List<String> genreList = new ArrayList<>(genrePlays.keySet());
		genreList.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return Integer.compare(genrePlays.get(b), genrePlays.get(a));
			}
		});

		// 장르별 두 곡 선택하여 저장
		List<Integer> result = new ArrayList<>();
		for (String genre : genreList) {
			List<Integer> songList = genreSongs.get(genre);

			// 노래 재생 순 정렬
			songList.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					if (plays[a] == plays[b]) {
						return Integer.compare(a, b);
					}
					return Integer.compare(plays[b], plays[a]);
				}
			});

			for (int i = 0; i < Math.min(2, songList.size()); i++) {
				result.add(songList.get(i));
			}
		}

		// 결과 list -> int[] 변환
		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
}
