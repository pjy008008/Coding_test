import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] tree, data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) Math.pow(2, h + 1);
		tree = new int[size];
		data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		build(1, 0, n - 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			System.out.println(query(1, 0, n - 1, a, b));
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
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}

	private static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int leftMax = query(node * 2, start, mid, left, right);
		int rightMax = query(node * 2 + 1, mid + 1, end, left, right);
		return Math.min(leftMax, rightMax);
	}
}
