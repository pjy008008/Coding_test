import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int x,y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        int count=0;
        for (int i = 1; i < n+1; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v) {
        isVisited[v]=true;
        for (Integer i : graph[v]) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }
}
