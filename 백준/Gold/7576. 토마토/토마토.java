import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int h;
    private static int w;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    q.offer(new int[]{i, j}); // y x순
                    visited[i][j] = true;
                }
                if (x == -1) {
                    visited[i][j] = true;
                }
                map[i][j] = x;
            }
        }
        bfs();
        System.out.println(solve());
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int x = position[1];
            int y = position[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        map[ny][nx] = map[y][x] + 1;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static int solve() {
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j]) {
                    return -1;
                }
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        return max - 1;
    }
}
 