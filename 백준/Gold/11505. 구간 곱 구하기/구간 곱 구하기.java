import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long[] tree;
	private static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) Math.pow(2, h + 1);
		tree = new long[size];
		data = new long[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		build(1, 0, n - 1);
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				update(1, 0, n - 1, a - 1, b);
			}
			if (cmd == 2) {
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
		tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1_000_000_007;
	}

	private static long query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 1;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		long leftV = query(node * 2, start, mid, left, right);
		long rightV = query(node * 2 + 1, mid + 1, end, left, right);
		return (leftV * rightV) % 1_000_000_007;
	}

	private static void update(int node, int start, int end, int idx, long value) {
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
		tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1_000_000_007;
	}
}
