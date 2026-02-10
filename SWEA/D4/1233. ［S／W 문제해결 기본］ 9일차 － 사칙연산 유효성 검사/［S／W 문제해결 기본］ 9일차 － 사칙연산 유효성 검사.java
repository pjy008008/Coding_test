import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            tree = new Node[n + 1];
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().trim().split(" ");
                int idx = Integer.parseInt(line[0]);
                Node node = null;
                if (line.length == 2) {
                    node = new Node(line[1]);
                }
                if (line.length == 4) {
                    node = new Node(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                }
                tree[idx] = node;
            }
            sb.append("#").append(i).append(" ");
            if (dfs(1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean dfs(int idx) {
        if (tree[idx] == null) {
            return false;
        }
        if (tree[idx].left == 0 || tree[idx].right == 0) {
            return !isOperator(idx);
        }
        boolean a = dfs(tree[idx].left);
        boolean b = dfs(tree[idx].right);
        if (!a || !b) {
            return false;
        }
        return isOperator(idx);
    }

    private static boolean isOperator(int idx) {
        return tree[idx].data.equals("+") || tree[idx].data.equals("-") || tree[idx].data.equals("*") || tree[idx].data.equals("/");
    }

    static class Node {
        String data;
        int left;
        int right;

        Node(String data) {
            this.data = data;
        }

        Node(String data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
