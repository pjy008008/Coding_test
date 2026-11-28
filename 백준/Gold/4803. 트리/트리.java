import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            int res=0;
            for (int i = 1; i <= n; i++) {
                // visited false 인 정점만 방문
                if (!visited[i]) {
                    if(dfs(i, 0)){
                        res++;
                    }
                }
            }
            sb.append("Case ").append(num).append(": ");
            if (res == 0) {
                sb.append("No trees.");
            } else if (res == 1) {
                sb.append("There is one tree.");
            }else {
                sb.append("A forest of ").append(res).append(" trees.");
            }
            sb.append("\n");
            num++;
        }
        System.out.println(sb);
    }

    private static boolean dfs(int idx, int parent) {
        visited[idx] = true;
        boolean isTree = true;

        for (int next : graph[idx]) {
            if (next == parent) {
                continue;
            }
            if(visited[next]){
                isTree = false;
                continue;
            }
            if(!dfs(next, idx)){
                isTree = false;
            }
        }
        return isTree;
    }

}