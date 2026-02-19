import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Edge>[] graph;
	private static boolean[] visited;
	private static int maxNode;
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		maxNode = 1;
		max = 0;
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e, w));
			graph[e].add(new Edge(s, w));
		}
		dfs(1, 0);
		max = 0;
		visited = new boolean[n + 1];
		dfs(maxNode, 0);
		System.out.println(max);
	}

	private static void dfs(int idx, int sum) {
		if (visited[idx]) {
			return;
		}
		if (max < sum) {
			max = sum;
			maxNode = idx;
		}
		visited[idx] = true;
		for (Edge e : graph[idx]) {
			dfs(e.des, sum + e.weight);
		}
	}

	static class Edge {
		int des;
		int weight;

		public Edge(int des, int weight) {
			this.des = des;
			this.weight = weight;
		}

	}
}
