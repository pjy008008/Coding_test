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
		int e = Integer.parseInt(st.nextToken());

		// initialize graph
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// initialize distance
		int[][] dist = new int[3][n + 1];
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i <= n; i++) {
				dist[j][i] = Integer.MAX_VALUE;
			}
		}

		// initialize edges
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, weight));
			graph[end].add(new Node(start, weight));
		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] startV = new int[3];
		startV[0] = 1;
		startV[1] = a;
		startV[2] = b;
		// start, a, b 정점에 대한 다익스트라
		for (int i = 0; i < 3; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(startV[i], 0));
			dist[i][startV[i]] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (dist[i][cur.v] < cur.w) {
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
		boolean flag = false;
		int min = Integer.MAX_VALUE;
		if (dist[0][a] != Integer.MAX_VALUE && dist[1][b] != Integer.MAX_VALUE && dist[2][n] != Integer.MAX_VALUE) {
			min = Math.min(min, dist[0][a] + dist[1][b] + dist[2][n]);
			flag = true;
		}
		if (dist[0][b] != Integer.MAX_VALUE && dist[2][a] != Integer.MAX_VALUE && dist[1][n] != Integer.MAX_VALUE) {
			min = Math.min(min, dist[0][b] + dist[2][a] + dist[1][n]);
			flag = true;
		}
		if (flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
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
