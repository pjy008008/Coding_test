import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		Node root = new Node(r);
		while (true) {
			String s = br.readLine();
			if (s==null)
				break;
			int x = Integer.parseInt(s);
			addNode(x, root);
		}
		dfs(root);
	}

	private static void dfs(Node cur) {
		if (cur.left != null) {
			dfs(cur.left);
		}
		if (cur.right != null) {
			dfs(cur.right);
		}
		System.out.println(cur.v);
	}

	private static void addNode(int x, Node cur) {
		if (x < cur.v) {
			if (cur.left == null) {
				cur.left = new Node(x);
				return;
			} else {
				addNode(x, cur.left);
			}
		} else {
			if (cur.right == null) {
				cur.right = new Node(x);
				return;
			} else {
				addNode(x, cur.right);
			}
		}
	}

	static class Node {
		int v;
		Node left;
		Node right;

		Node(int v) {
			this.v = v;
		}
	}
}
