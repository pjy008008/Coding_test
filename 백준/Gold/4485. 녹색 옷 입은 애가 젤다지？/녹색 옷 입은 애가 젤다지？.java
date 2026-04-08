import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            cnt++;
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));
            dist[0][0] = map[0][0];
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (dist[cur.y][cur.x] < cur.w) {
                    continue;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (dist[ny][nx] > dist[cur.y][cur.x] + map[ny][nx]) {
                            dist[ny][nx] = dist[cur.y][cur.x] + map[ny][nx];
                            pq.offer(new Node(nx, ny, dist[ny][nx]));
                        }
                    }
                }
            }
            sb.append("Problem ").append(cnt).append(": ").append(dist[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;

        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}