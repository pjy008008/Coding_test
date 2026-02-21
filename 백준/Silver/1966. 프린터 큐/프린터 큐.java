import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] priority = new int[10];
            Queue<Node> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                priority[x]++;
                q.offer(new Node(j, x));
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                boolean hasHigher = false;

                for (int j = cur.p + 1; j <= 9; j++) {
                    if (priority[j] > 0) {
                        hasHigher = true;
                        break;
                    }
                }
                if (hasHigher) {
                    q.offer(cur);
                } else {
                    cnt++;
                    priority[cur.p]--;
                    if (cur.idx == m) {
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int idx;
        int p;

        public Node(int idx, int p) {
            this.idx = idx;
            this.p = p;
        }
    }
}