import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[][] dist = new int[v + 1][v + 1];
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[a][b] = w;
        }
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (dist[i][j] == 0) {
                    dist[i][j] = 1_000_000_000;
                }
            }
        }

        for (int m = 1; m <= v; m++) {
            for (int s = 1; s <= v; s++) {
                for (int e = 1; e <= v; e++) {
                    if (dist[s][e] > dist[s][m] + dist[m][e]) {
                        dist[s][e] = dist[s][m] + dist[m][e];
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            res = Math.min(res, dist[i][i]);
        }

        if (res == 1_000_000_000) {
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }
}