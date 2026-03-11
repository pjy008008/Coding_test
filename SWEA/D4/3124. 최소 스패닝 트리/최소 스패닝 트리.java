import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[v + 1];

			ArrayList<Node>[] graph = new ArrayList[v + 1];
			for (int j = 1; j <= v; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[start].add(new Node(end, weight));
				graph[end].add(new Node(start, weight));
			}

			long res = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[cur.v]) {
					continue;
				}
				res += cur.w;
				visited[cur.v] = true;
				for (Node next : graph[cur.v]) {
					if (!visited[next.v]) {
						pq.offer(next);
					}
				}
			}
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
