import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int num;
	private static int goal;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			visited = new boolean[10000];
			num = Integer.parseInt(st.nextToken());
			goal = Integer.parseInt(st.nextToken());
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	private static String bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(num, ""));
		visited[num] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.num == goal) {
				return node.cmd;
			}
			int d = cmdD(node.num);
			if (!visited[d]) {
				visited[d] = true;
				q.add(new Node(d, node.cmd + "D"));
			}
			int s = cmdS(node.num);
			if (!visited[s]) {
				visited[s] = true;
				q.add(new Node(s, node.cmd + "S"));
			}
			int l = cmdL(node.num);
			if (!visited[l]) {
				visited[s] = true;
				q.add(new Node(l, node.cmd + "L"));
			}
			int r = cmdR(node.num);
			if (!visited[r]) {
				visited[s] = true;
				q.add(new Node(r, node.cmd + "R"));
			}
		}
		return "";
	}

	private static int cmdD(int x) {
		x = x * 2;
		return x > 9999 ? x % 10000 : x;
	}

	private static int cmdS(int x) {
		x -= 1;
		return x == -1 ? 9999 : x;
	}

	private static int cmdL(int x) {
		int last = x / 1000;
		x -= last * 1000;
		x *= 10;
		return x + last;
	}

	private static int cmdR(int x) {
		int first = x % 10;
		x /= 10;
		return first * 1000 + x;
	}

	static class Node {
		int num;
		String cmd;

		public Node(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}
}
