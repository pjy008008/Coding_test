import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static int[] parent;
	private static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		depth = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		// initialize parent, depth
		init(0, 1);

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
		while (depth[u] != depth[v]) {
			if (depth[u] > depth[v]) {
				u = parent[u];
			}
			if (depth[u] < depth[v]) {
				v = parent[v];
			}
		}
		while (u != v) {
			u = parent[u];
			v = parent[v];
		}
		return u;
	}

	private static void init(int prev, int cur) {
		for (int next : graph[cur]) {
			if (prev == next) {
				continue;
			}
			parent[next] = cur;
			depth[next] = depth[cur] + 1;
			init(cur, next);
		}
	}
}
