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
		int n = Integer.parseInt(st.nextToken()); // number of village
		int m = Integer.parseInt(st.nextToken()); // number of road
		int x = Integer.parseInt(st.nextToken()); // starting point
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		ArrayList<Node>[] revGraph = new ArrayList[n + 1];
		int[] dist = new int[n + 1];
		int[] revDist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			revGraph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
			revDist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, w));
			revGraph[e].add(new Node(s, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x, 0));
		dist[x] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.v] < cur.w) {
				continue;
			}
			for (Node next : graph[cur.v]) {
				if (dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, cur.w + next.w));
				}
			}
		}
		pq = new PriorityQueue<>();
		pq.offer(new Node(x, 0));
		revDist[x] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (revDist[cur.v] < cur.w) {
				continue;
			}
			for (Node next : revGraph[cur.v]) {
				if (revDist[next.v] > cur.w + next.w) {
					revDist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, cur.w + next.w));
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE || revDist[i] == Integer.MAX_VALUE) {
				continue;
			}
			if (dist[i] + revDist[i] > max) {
				max = dist[i] + revDist[i];
			}
		}
		System.out.println(max);
	}

	static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
