import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static Edge[] edges;
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parents = new int[v + 1];
		for (int i = 0; i <= v; i++) {
			parents[i] = i;
		}
		edges = new Edge[e];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, weight);
		}
		Arrays.sort(edges);
		int sum = edges[0].w;
		union(edges[0].s, edges[0].e);
		for (int i = 1; i < e; i++) {
			if (find(edges[i].s) != find(edges[i].e)) {
				union(edges[i].s, edges[i].e);
				sum += edges[i].w;
			}
		}
		System.out.println(sum);
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parents[b] = a;
		}
	}

	private static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}
}
