import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int x,y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            int count=1;
            dfs(i,count);
        }
        System.out.println(0);
    }

    public static void dfs(int v,int count) {
        isVisited[v]=true;
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }
        for (int i : graph[v]) {
            if (isVisited[i]) {
                continue;
            }
            dfs(i,count+1);
        }
        isVisited[v] =false;
    }
}
