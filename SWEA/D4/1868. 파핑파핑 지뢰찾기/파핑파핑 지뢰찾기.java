import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 0이라면 8방 탐색, 0이 아니면 stop
public class Solution {
    private static int n;
    private static char[][] map;
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            cnt = 0;
            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                for (int k = 0; k < n; k++) {
                    map[j][k] = line.charAt(k);
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] == '.' && countMines(k, j) == 0) {
                        cnt++;
                        bfs(k, j);
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] == '.') {
                        cnt++;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        map[y][x] = (char) (countMines(x, y) + '0');
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (map[cy][cx] == '0') {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = (char) (countMines(nx, ny) + '0');
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    
    private static int countMines(int x, int y) {
        int mCnt = 0;
        for (int dir = 0; dir < 8; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[ny][nx] == '*') mCnt++;
            }
        }
        return mCnt;
    }
}
