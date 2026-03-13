import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static long[] tree;
	private static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		tree = new long[4 * n];
//		최적의 tree size		
//		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
//		int treeSize = (int) Math.pow(2, h + 1);
		data = new long[n];
		for (int i = 0; i < n; i++) {
			data[i] = Long.parseLong(br.readLine());
		}
		build(1, 0, n - 1);
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if (cmd == 1) {
				// a-1 번째를 b로 변경
				update(1, 0, n - 1, a - 1, b);
			}
			if (cmd == 2) {
				// a-1 ~ b-1 까지 구간합
				System.out.println(query(1, 0, n - 1, a - 1, b - 1));
			}
		}
	}

	private static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = data[start];
			return;
		}
		int mid = (start + end) / 2;
		build(node * 2, start, mid);
		build(node * 2 + 1, mid + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	private static long query(int node, int start, int end, long left, long right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		long leftSum = query(node * 2, start, mid, left, right);
		long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
		return leftSum + rightSum;
	}

	private static void update(int node, int start, int end, long idx, long value) {
		if (idx > end || idx < start) {
			return;
		}
		if (start == end) {
			tree[node] = value;
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, value);
		update(node * 2 + 1, mid + 1, end, idx, value);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
