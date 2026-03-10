import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	private static int[] parent;
	private static int[] selected;
	private static int[][] islands;
	private static ArrayList<Edge> edges;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			edges = new ArrayList<>();
			islands = new int[n][2];
			parent = new int[n];
			selected = new int[2];
			for (int j = 0; j < n; j++) {
				parent[j] = j;
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				islands[j][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				islands[j][1] = Integer.parseInt(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());
			comb(0, 0);
			Collections.sort(edges);
			long sum = 0;
			for (int j = 0; j < edges.size(); j++) {
				Edge edge = edges.get(j);
				if (find(edge.s) != find(edge.e)) {
					union(edge.s, edge.e);
					sum += edge.w;
				}
			}
			sb.append("#").append(i).append(" ").append(Math.round(e * sum)).append("\n");
		}
		System.out.println(sb);
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

	private static void comb(int start, int cnt) {
		if (cnt == 2) {
			makeEdges(selected);
			return;
		}
		for (int i = start; i < n; i++) {
			selected[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	private static void makeEdges(int[] selected) {
		int a = selected[0];
		int b = selected[1];
		double dis = Math.pow(islands[a][0] - islands[b][0], 2) + Math.pow(islands[a][1] - islands[b][1], 2);
		edges.add(new Edge(selected[0], selected[1], dis));
	}

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		double w;

		Edge(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}

	}
}
