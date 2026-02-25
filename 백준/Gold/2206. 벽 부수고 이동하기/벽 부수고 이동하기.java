import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == m - 1 && cur.y == n - 1) {
                System.out.println(cur.dis);
                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (map[ny][nx] == 0) {
                        if (!visited[cur.wall][ny][nx]) {
                            visited[cur.wall][ny][nx] = true;
                            q.offer(new Node(nx, ny, cur.dis + 1, cur.wall));
                        }
                    } else if (map[ny][nx] == 1) {
                        if (cur.wall == 0 && !visited[1][ny][nx]) {
                            visited[1][ny][nx] = true;
                            q.offer(new Node(nx, ny, cur.dis + 1, 1));
                        }
                    }

                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int x;
        int y;
        int dis;
        int wall;

        public Node(int x, int y, int dis, int wall) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wall = wall;
        }
    }
}
