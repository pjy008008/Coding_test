import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(new Node(i, x));
		}
		Collections.sort(list);
		int[] res = new int[n];
		int last = list.get(0).value;
		int cnt = 0;
		res[list.get(0).idx] = 0;
		for (int i = 1; i < n; i++) {
			Node cur = list.get(i);
			if (cur.value != last) {
				cnt++;
				last = cur.value;
			}
			res[cur.idx] = cnt;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int value;
		int idx;

		Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
}
