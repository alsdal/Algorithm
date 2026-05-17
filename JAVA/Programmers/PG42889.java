import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PG42889 {
	public static void main(String args[]) {
		int[] arr = solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 });

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int N, int[] stages) {
		int[] failed = new int[N + 2]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수

		for (int stage : stages) {
			failed[stage]++;
		}

		int players = stages.length; // 스테이지에 도달한 플레이어 수

		// 실패율 계산
		List<Stage> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			double failRate = 0; // 실패율
			if (players != 0) {
				failRate = (double) failed[i] / players;
			}
			list.add(new Stage(i, failRate));
			players -= failed[i];
		}

		// 실패율 기준 정렬
		Collections.sort(list, new Comparator<Stage>() {
			@Override
			public int compare(Stage a, Stage b) {
				if (a.rate != b.rate) {
					return Double.compare(b.rate, a.rate);
				}
				return a.num - b.num;
			}
		});

		// 리스트 -> 배열 변환
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = list.get(i).num;
		}
		return answer;
	}

	static class Stage {
		int num;
		double rate;

		Stage(int num, double rate) {
			this.num = num;
			this.rate = rate;
		}
	}
}
