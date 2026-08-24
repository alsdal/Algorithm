/*
문제 : 데이터 분석
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250121
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PG250121 {
	public static void main(String[] args) {
		int[][] arr = solution(
				new int[][] { { 1, 20300104, 100, 80 }, { 2, 20300804, 847, 37 }, { 3, 20300401, 10, 8 } }, "date",
				20300501, "remain");
		for (int[] a : arr) {
			for (int i : a) {
				System.out.println(i);
			}
		}
	}

	public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int extIdx = getIdx(ext);
		int sortIdx = getIdx(sort_by);

		List<int[]> answer = new ArrayList<>();

		// 날짜 조건 거르기
		for (int[] d : data) {
			if (d[extIdx] < val_ext) {
				answer.add(d);
			}
		}

		// 인덱스 기준 정렬
		Collections.sort(answer, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[sortIdx] - b[sortIdx];
			}
		});

		return answer.toArray(new int[answer.size()][]);
	}

	// 인덱스로 변환
	public static int getIdx(String s) {
		if (s.equals("code")) {
			return 0;
		} else if (s.equals("date")) {
			return 1;
		} else if (s.equals("maximum")) {
			return 2;
		} else {
			return 3;
		}
	}
}
