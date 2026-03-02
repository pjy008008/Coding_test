import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static long[] dist;
    private static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, w));
        }
        if (bellmanFord(1)) {
            for (int i = 2; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    System.out.println(dist[i]);
                } else {
                    System.out.println(-1);
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean bellmanFord(int start) {
        dist[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges.get(j);
                if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.e] > dist[edge.s] + edge.w) {
                    dist[edge.e] = dist[edge.s] + edge.w;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Edge edge = edges.get(i);
            if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.e] > dist[edge.s] + edge.w) {
                return false;
            }
        }
        return true;
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
