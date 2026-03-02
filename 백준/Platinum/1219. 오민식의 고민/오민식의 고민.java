import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, start, end;
    private static long[] dist;
    private static Edge[] edges;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init dist
        dist = new long[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MIN_VALUE;
        }

        // init edges
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, w);
        }

        st = new StringTokenizer(br.readLine());
        cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dist[start] = cost[start];
        for (int i = 0; i <= n + 100; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                int s = edge.s;
                int e = edge.e;
                int w = edge.w;
                if (dist[s] != Long.MIN_VALUE && dist[e] < dist[s] + cost[e] - w) {
                    dist[e] = dist[s] + cost[e] - w;
                    if (i >= n - 1) {
                        // N-1 번 이후는 업데이트 되면 양수 사이클임
                        dist[e] = Long.MAX_VALUE;
                    }
                } else if (dist[s] == Long.MAX_VALUE) {
                    // 양수 사이클과 연결되어 있을 경우
                    dist[e] = Long.MAX_VALUE;
                }
            }
        }

        long res = dist[end];
        if (res == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (res == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(res);
        }
    }

    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
