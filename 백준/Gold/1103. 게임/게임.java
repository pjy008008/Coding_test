import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] dp;
    private static boolean[][] visited;
    private static boolean infiniteFlag;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        visited = new boolean[n][m];
        infiniteFlag = false;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (Character.isDigit(c)) {
                    map[i][j] = line.charAt(j) - '0';
                } else {
                    map[i][j] = -1;
                }
            }
        }
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (infiniteFlag) return -1;
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        if (map[y][x] == -1) {
            return 0;
        }
        visited[y][x] = true;
        int res = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir] * map[y][x];
            int ny = y + dy[dir] * map[y][x];
            if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                if (visited[ny][nx]) {
                    infiniteFlag = true;
                    return -1;
                } else {
                    res = Math.max(res, dfs(nx, ny) + 1);
                    if (infiniteFlag) {
                        return -1;
                    }
                }
            }
        }
        visited[y][x] = false;
        return dp[y][x] = res;
    }
}