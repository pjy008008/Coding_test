import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] tree;
	private static int[][] parent;
	private static int[] depth;
	private static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		// find possible max depth
		int temp = 1;
		size = 0;
		while (temp <= n) {
			temp <<= 1;
			size++;
		}
		parent = new int[size + 1][n + 1];
		depth = new int[n + 1];
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		// initialize parent, depth
		init(0, 1);

		// dp
		for (int i = 1; i < size; i++) {
			for (int j = 1; j <= n; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}

		// query
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(getLCA(u, v)).append("\n");
		}
		System.out.println(sb);
	}

	private static int getLCA(int u, int v) {
		// v always bigger than u
		if (depth[u] > depth[v]) {
			int temp = u;
			u = v;
			v = temp;
		}

		for (int k = size; k >= 0; k--) {
			if (depth[v] - (1 << k) >= depth[u]) {
				v = parent[k][v];
			}
		}

		if (u == v) {
			return u;
		}
		for (int k = size; k >= 0; k--) {
			if (parent[k][u] != parent[k][v]) {
				u = parent[k][u];
				v = parent[k][v];
			}
		}

		return parent[0][u];
	}

	private static void init(int prev, int cur) {
		for (int next : tree[cur]) {
			if (prev == next) {
				continue;
			}
			parent[0][next] = cur;
			depth[next] = depth[cur] + 1;
			init(cur, next);
		}
	}
}
