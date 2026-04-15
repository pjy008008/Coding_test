import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static long temp;
	private static long[] res;
	private static boolean[] visited;
	private static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		res = new long[n];
		visited = new boolean[n];
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		temp = 1;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, p, q));
			graph[b].add(new Node(a, q, p));
			temp *= p * q / gcd(p, q);
		}
		res[0] = temp;
		dfs(0);
		long mgcd = res[0];
		for (int i = 1; i < n; i++) {
			mgcd = gcd(mgcd, res[i]);
		}
		for (int i = 0; i < n; i++) {
			sb.append(res[i] / mgcd + " ");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx) {
		if (visited[idx]) {
			return;
		}
		visited[idx] = true;
		for (Node next : graph[idx]) {
			res[next.idx] = res[idx] * next.q / next.p;
			dfs(next.idx);
		}
	}

	private static long gcd(long a, long b) {
		long r = a % b;
		if (r == 0) {
			return b;
		}
		return gcd(b, r);
	}

	static class Node {
		int idx;
		int p;
		int q;

		Node(int idx, int p, int q) {
			this.idx = idx;
			this.p = p;
			this.q = q;
		}
	}
}
