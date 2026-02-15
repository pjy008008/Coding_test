import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            Node[] tree = new Node[n + 1];
            for (int j = 0; j < n + 1; j++) {
                tree[j] = new Node();
            }
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                tree[idx].c = st.nextToken();
                if (st.hasMoreTokens()) {
                    tree[idx].left = tree[Integer.parseInt(st.nextToken())];
                }
                if (st.hasMoreTokens()) {
                    tree[idx].right = tree[Integer.parseInt(st.nextToken())];
                }
            }
            sb.append("#").append(i).append(" ");
            dfs(tree[1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(Node n) {
        if (n == null) {
            return;
        }
        dfs(n.left);
        sb.append(n.c);
        dfs(n.right);
    }

    static class Node {
        String c;
        Node left;
        Node right;

        Node() {
        }
    }
}
