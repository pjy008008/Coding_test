import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] parent;
	private static PriorityQueue<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		edges = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.offer(new Edge(s, e, w));
		}

		int cnt = 0;
		int res = 0;
		for (int i = 0; i < m; i++) {
			Edge edge = edges.poll();
			if (cnt == n - 2) {
				break;
			}
			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				res += edge.w;
				cnt++;
			}
		}
		System.out.println(res);
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	static class Edge {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
}
