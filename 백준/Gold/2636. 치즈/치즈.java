import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int h, w;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        int res2 = 0;
        while (true) {
            int left = check();
            if (left == 0) {
                break;
            }
            res++;
            res2 = left;
            bfs();
        }
        System.out.println(res);
        System.out.println(res2);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[h][w];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{nx, ny});
                    } else if (map[ny][nx] == 1) {
                        map[ny][nx] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int check() {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}