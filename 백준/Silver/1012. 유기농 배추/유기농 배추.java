import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m, n;
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int p = 0; p < t; p++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            visit = new boolean[n][m];
            int k = Integer.parseInt(st.nextToken());
            int x, y;
            int[][] c = new int[k][2];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                graph[x][y]=1;
                c[i][0] = x;
                c[i][1] = y;
            }
            //배추가 심어진 k개의 좌표에 대해 bfs실행
            for (int i = 0; i < k; i++) {
                bfs(c[i]);
            }
            System.out.println(count);
            count=0;
        }
    }

    public static void bfs(int[] now) {
        if (visit[now[0]][now[1]]) {
            return;
        }
        visit[now[0]][now[1]]=true;
        count++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{now[0], now[1]});
        while (!queue.isEmpty()) {
            int[] k = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + k[0];
                int y = dy[i] + k[1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (graph[x][y] == 1 && !visit[x][y]) {
                        queue.add(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }
    }
}