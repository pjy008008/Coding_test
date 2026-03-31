import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static int[] parent;
	private static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n + 1];
			depth = new int[n + 1];
			graph = new ArrayList[n + 1];
			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<>();
			}
			Set<Integer> set = new HashSet<>();
			for (int j = 1; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				set.add(v);
				graph[u].add(v);
				graph[v].add(u);
			}
			// find root
			int root = 0;
			for (int j = 1; j <= n; j++) {
				if (!set.contains(j)) {
					root = j;
					break;
				}
			}
			
			// initialize parent, depth
			init(0, root);

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
