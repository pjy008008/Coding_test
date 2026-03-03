import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                int x = 0;
                if (c == '0') {
                    map[i][j] = 0;
                }
                if ('a' <= c && c <= 'z') {
                    x = c - 'a' + 1;
                }
                if ('A' <= c && c <= 'Z') {
                    x = c - 'A' + 27;
                }
                sum += x;
                map[i][j] = x;
            }
        }

        // init parent
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // store edges
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || map[i][j] == 0) {
                    continue;
                }
                pq.add(new Edge(i, j, map[i][j]));
            }
        }

        // MST
        int connectedSum = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.s) != find(e.e)) {
                union(e.s, e.e);
                connectedSum += e.w;
            }
        }

        boolean connected = true;
        int x = find(0);
        for (int i = 1; i < n; i++) {
            if (x != find(i)) {
                connected = false;
            }
        }
        if (!connected) {
            System.out.println(-1);
        } else {
            System.out.println(sum - connectedSum);
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}