import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static int[] sz;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // vertex
		int r = Integer.parseInt(st.nextToken()); // root
		int q = Integer.parseInt(st.nextToken()); // query

		sz = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		dfs(r, 0);
		for (int i = 0; i < q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(sz[query]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, int prev) {
		sz[cur] = 1;
		for (int next : graph[cur]) {
			if (prev == next) {
				continue;
			}
			dfs(next, cur);
			sz[cur] += sz[next];
		}
	}
}
