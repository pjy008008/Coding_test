import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] map;
    private static int n;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int maxDepth;
    private static int maxPos;
    private static int curPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            maxDepth = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    curPos = map[k][j];
                    dfs(j, k, 1);
                }
            }
            sb.append("#").append(i).append(" ").append(maxPos).append(" ").append(maxDepth).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            maxPos = curPos;
        } else if (depth == maxDepth) {
            if (curPos < maxPos) {
                maxPos = curPos;
            }
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[ny][nx] == map[y][x] + 1) {
                    dfs(nx, ny, depth + 1);
                }
            }
        }
    }
}
