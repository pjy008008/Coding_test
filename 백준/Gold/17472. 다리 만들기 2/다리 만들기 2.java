import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m;
    private static int island;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] parent;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        island = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bfs(j, i)) {
                    island++;
                }
            }
        }
        island--;
        // parent init
        parent = new int[island + 1];
        for (int i = 1; i <= island; i++) {
            parent[i] = i;
        }

        // find edge & store edges
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    findEdge(j, i, map[i][j]);
                }
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.s) != find(e.e)) {
                union(e.s, e.e);
                sum += e.w;
            }
        }

        int x = find(1);
        boolean impossible = false;
        for (int i = 2; i <= island; i++) {
            if (find(i) != x) {
                impossible = true;
            }
        }
        if (impossible) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
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

    private static void findEdge(int x, int y, int island) {
        for (int dir = 0; dir < 4; dir++) {
            int w = 1;
            while (true) {
                int nx = x + w * dx[dir];
                int ny = y + w * dy[dir];
                if (!inRange(nx, ny)) {
                    break;
                }
                if (map[ny][nx] == island) {
                    break;
                }
                if (map[ny][nx] != 0) {
                    if (w - 1 >= 2) {
                        pq.offer(new Edge(island, map[ny][nx], w - 1));
                    }
                    break;
                }
                w++;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            return true;
        }
        return false;
    }

    private static boolean bfs(int x, int y) {
        if (map[y][x] == 0 || visited[y][x]) {
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;
        map[y][x] = island;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if (inRange(nx, ny)) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        map[ny][nx] = island;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return true;
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