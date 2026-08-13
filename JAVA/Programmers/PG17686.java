/*
문제 : 파일명 정렬
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17686
*/

import java.util.Arrays;
import java.util.Comparator;

public class PG17686 {
	public static void main(String[] args) {
		String[] arr = solution(
				new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });

		for (String s : arr) {
			System.out.println(s);
		}
	}

	static class File {
		String name;
		String head;
		int number;

		File(String name, String head, int number) {
			this.name = name;
			this.head = head;
			this.number = number;
		}
	}

	public static String[] solution(String[] files) {
		File[] arr = new File[files.length];

		// 파일명 분리
		for (int i = 0; i < files.length; i++) {
			String file = files[i];

			// number 시작 지점 찾기
			int numberStart = 0;
			while (!Character.isDigit(file.charAt(numberStart))) {
				numberStart++;
			}

			// number 끝 지점 찾기
			int numberEnd = numberStart;
			while (numberEnd < file.length() && Character.isDigit(file.charAt(numberEnd))) {
				numberEnd++;
			}

			// head, number 분리
			String head = file.substring(0, numberStart);
			int number = Integer.parseInt(file.substring(numberStart, numberEnd));

			arr[i] = new File(file, head, number);
		}

		Arrays.sort(arr, new Comparator<File>() {
			@Override
			public int compare(File a, File b) {
				// head 비교
				int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase());
				if (headCompare != 0) {
					return headCompare;
				}

				// head 같을 경우 number 비교
				return a.number - b.number;
			}
		});

		String[] answer = new String[files.length];

		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i].name;
		}

		return answer;
	}
}
