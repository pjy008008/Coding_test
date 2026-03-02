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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // init graph
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // init all dist
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : graph[cur.v]) {
                if (dist[next.v].size() < k) {
                    dist[next.v].offer(next.w + cur.w);
                    pq.offer(new Node(next.v, next.w + cur.w));
                } else if (dist[next.v].peek() > next.w + cur.w) {
                    dist[next.v].poll();
                    dist[next.v].add(next.w + cur.w);
                    pq.offer(new Node(next.v, next.w + cur.w));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i].peek());
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}