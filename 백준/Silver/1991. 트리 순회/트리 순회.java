import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Node[] tree = new Node[27];
		for (int i = 1; i <= 26; i++) {
			tree[i] = new Node();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			int idx = data - 'A' + 1;
			tree[idx].data = data;
			int left = st.nextToken().charAt(0);
			int right = st.nextToken().charAt(0);
			if (left == '.') {
				tree[idx].left = null;
			} else {
				tree[idx].left = tree[left - 'A' + 1];
			}
			if (right == '.') {
				tree[idx].right = null;
			} else {
				tree[idx].right = tree[right - 'A' + 1];
			}
		}
		dfs1(tree[1]);
		sb.append("\n");
		dfs2(tree[1]);
		sb.append("\n");
		dfs3(tree[1]);
		System.out.println(sb);
	}

	private static void dfs1(Node c) {
		if (c == null) {
			return;
		}
		sb.append(c.data);
		dfs1(c.left);
		dfs1(c.right);
	}

	private static void dfs2(Node c) {
		if (c == null) {
			return;
		}
		dfs2(c.left);
		sb.append(c.data);
		dfs2(c.right);
	}

	private static void dfs3(Node c) {
		if (c == null) {
			return;
		}
		dfs3(c.left);
		dfs3(c.right);
		sb.append(c.data);
	}

	static class Node {
		char data;
		Node left;
		Node right;

		Node() {
		}
	}
}
