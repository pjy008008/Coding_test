import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n, cnt;
    private static int remove;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cnt = 0;
        int root = 0;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
            } else {
                graph[p].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        dfs(root);
        System.out.println(cnt);
    }

    private static void dfs(int root) {
        if (root == remove) {
            return;
        }
        if (graph[root].isEmpty()) {
            cnt++;
        }
        if (graph[root].size() == 1 && graph[root].get(0) == remove) {
            cnt++;
        }
        for (int next : graph[root]) {
            dfs(next);
        }
    }
}