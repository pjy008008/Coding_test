import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int se = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(sx, se, 0));
            visited[se][sx] = true;
            int res = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.x == ex && cur.y == ey) {
                    res = cur.depth;
                    break;
                }
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            q.offer(new Node(nx, ny, cur.depth + 1));
                        }
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}