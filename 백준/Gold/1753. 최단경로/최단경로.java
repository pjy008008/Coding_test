import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Node>[] graph;
	private static int v, e, k;
	private static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		graph = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		distance = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, weight));
		}
		dijkstra(k);
		for (int i = 1; i <= v; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		distance[start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (distance[n.des] < n.weight)
				continue;
			for (Node x : graph[n.des]) {
				if (distance[x.des] > distance[n.des] + x.weight) {
					distance[x.des] = distance[n.des] + x.weight;
					pq.offer(new Node(x.des, distance[n.des] + x.weight));
				}
			}
		}
	}

	static class Node {
		int des;
		int weight;

		public Node(int des, int weight) {
			super();
			this.des = des;
			this.weight = weight;
		}
	}
}
