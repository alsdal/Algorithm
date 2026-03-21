import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 배열의 크기
		node[] A = new node[N];

		for (int i = 0; i < N; i++) {
			A[i] = new node(Integer.parseInt(br.readLine()), i);
		}

		Arrays.sort(A); // 정렬 O(nlogn)

		int max = 0;
		// 정렬 전 인덱스 - 정렬 후 인덱스 값의 최댓값 구하기
		for (int i = 0; i < N; i++) {
			if (max < A[i].idx - i) {
				max = A[i].idx - i;
			}
		}
		System.out.println(max + 1);
	}
}

class node implements Comparable<node> {
	int val;
	int idx;

	public node(int val, int idx) {
		super();
		this.val = val;
		this.idx = idx;
	}

	@Override
	public int compareTo(node o) {
		return this.val - o.val;
	}
}

/*
 * 10 1 5 2 3
 *
 * i=1
 * 1 10 5 2 3 
 * 1 5 10 2 3 
 * 1 5 2 10 3 
 * 1 5 2 3 10
 * 
 * i=2 
 * 1 5 2 3 10 
 * 1 2 5 3 10 
 * 1 2 3 5 10
 * 
 * i=3 
 * 1 2 3 5 10
 */