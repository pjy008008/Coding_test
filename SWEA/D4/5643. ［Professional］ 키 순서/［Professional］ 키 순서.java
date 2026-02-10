import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] graph = new int[n + 1][n + 1];
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j == k) {
                        graph[j][k] = 0;
                    } else {
                        graph[j][k] = 10000001;
                    }
                }
            }
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }
            graph = floyd(graph, n);
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(check(graph, n, j)){
                    cnt++;
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int[][] floyd(int[][] graph, int n) {
        for (int m = 1; m < n + 1; m++) {
            for (int s = 1; s < n + 1; s++) {
                for (int e = 1; e < n + 1; e++) {
                    if (graph[s][e] > graph[s][m] + graph[m][e]) {
                        graph[s][e] = graph[s][m] + graph[m][e];
                    }
                }
            }
        }
        return graph;
    }

    private static boolean check(int[][] graph, int n, int student) {
        boolean[] isAll = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (graph[i][student] < 10000001 || graph[student][i] < 10000001) {
                isAll[i] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (!isAll[i]) {
                return false;
            }
        }
        return true;
    }
}
