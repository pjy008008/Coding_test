import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int a;
    private static int b;
    private static int parent;
    private static int[] sz;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            parent = 0;
            sz = new int[v + 1];
            Node[] tree = new Node[v + 1];
            for (int j = 1; j < v + 1; j++) {
                tree[j] = new Node(j);  // tree 초기화
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < e; j++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tree[start].add(tree[end]);
            }
            dfs(tree[1]);
            sb.append("#").append(i).append(" ").append(parent).append(" ").append(sz[parent]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean dfs(Node n) {
        if (n == null) {
            return false;
        }
        sz[n.id] = 1;
        boolean left = dfs(n.left);
        boolean right = dfs(n.right);

        if (n.left != null) {
            sz[n.id] += sz[n.left.id];
        }
        if (n.right != null) {
            sz[n.id] += sz[n.right.id];
        }

        boolean cur = (n.id == a || n.id == b);

        if ((left && right) || (cur && (left || right))) {
            parent = n.id;
        }
        return cur || left || right;
    }

    static class Node {
        int id;
        Node left;
        Node right;

        Node(int id) {
            this.id = id;
        }

        private void add(Node n) {
            if (left == null) {
                this.left = n;
                return;
            } else {
                this.right = n;
            }
        }
    }
}
