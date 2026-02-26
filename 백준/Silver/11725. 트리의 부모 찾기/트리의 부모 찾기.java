import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] tree;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}

		dfs(0, 1);
		
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int prev, int cur) {
		for (int next : tree[cur]) {
			if (next == prev) {
				continue;
			}
			parent[next] = cur;
			dfs(cur, next);
		}
	}
}
