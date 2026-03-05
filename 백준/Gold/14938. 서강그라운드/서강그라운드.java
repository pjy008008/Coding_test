import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] items = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		// initialize graph
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, w));
			graph[e].add(new Node(s, w));
		}

		// initialize distance array
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i <= n; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(i, 0));
			dist[i][i] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (dist[i][cur.v] > cur.w) {
					continue;
				}
				for (Node next : graph[cur.v]) {
					if (dist[i][next.v] > dist[i][cur.v] + next.w) {
						dist[i][next.v] = dist[i][cur.v] + next.w;
						pq.offer(new Node(next.v, dist[i][cur.v] + next.w));
					}
				}
			}
		}
		int[] count = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int sum = items[i];
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}
				if (dist[i][j] <= m) {
					sum += items[j];
				}
			}
			count[i] = sum;
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (count[i] > max) {
				max = count[i];
			}
		}
		System.out.println(max);
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
