import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int x, y, d;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        // initialize map
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true) {
            if (map[y][x] == 0 && !visited[y][x]) {
                visited[y][x] = true;
                cnt++;
            } else {
                if (check()) {
                    d = (d + 3) % 4;
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (checkRange(nx, ny) && map[ny][nx] == 0 && !visited[ny][nx]) {
                        x = nx;
                        y = ny;
                    }
                } else {
                    int tempD = (d + 2) % 4;
                    int nx = x + dx[tempD];
                    int ny = y + dy[tempD];
                    if (checkRange(nx, ny) && map[ny][nx] != 1) {
                        x = nx;
                        y = ny;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean check() {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (checkRange(nx, ny)) {
                if (map[ny][nx] == 0 && !visited[ny][nx]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkRange(int x, int y) {
        return (0 <= x && x < m && 0 <= y && y < n);
    }
}