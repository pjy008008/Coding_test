import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int house;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = bfs(j, i);
                if (res != -1) {
                    list.add(res);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int x : list) {
            System.out.println(x);
        }
    }

    private static int bfs(int x, int y) {
        if (visited[y][x] || map[y][x] == 0) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        cnt++;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return cnt;
    }
}