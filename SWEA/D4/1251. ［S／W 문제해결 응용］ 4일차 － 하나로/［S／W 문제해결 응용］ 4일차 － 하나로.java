import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] islands;
	private static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[n];
			// init islands
			islands = new int[n][2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				islands[j][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				islands[j][1] = Integer.parseInt(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());

			// init graph
			graph = new ArrayList[n];
			for (int j = 0; j < n; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					makeEdge(j, k);
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.w, o2.w));
			pq.offer(new Node(0, 0));
			long sum = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[cur.v])
					continue;
				visited[cur.v] = true;
				sum += cur.w;
				for (Node next : graph[cur.v]) {
					if (!visited[next.v]) {
						pq.offer(next);
					}
				}
			}
			long res = Math.round(e * sum);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void makeEdge(int a, int b) {
		long dis1 = (long) Math.pow(islands[a][0] - islands[b][0], 2);
		long dis2 = (long) Math.pow(islands[a][1] - islands[b][1], 2);
		graph[a].add(new Node(b, dis1 + dis2));
		graph[b].add(new Node(a, dis1 + dis2));
	}

	static class Node {
		int v;
		long w;

		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
	}
}
