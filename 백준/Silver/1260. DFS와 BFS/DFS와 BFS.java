import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static Queue<Integer> myQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
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
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        dfs(startV);
        System.out.println();
        isVisited = new boolean[n + 1];
        bfs(startV);
    }

    public static void dfs(int v) {
        isVisited[v] = true;
        System.out.print(v+" ");
        for (int i : graph[v]) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }
    public static void bfs(int v) {
        isVisited[v]=true;
        System.out.print(v+" ");
        for (int i : graph[v]) {
            if(!isVisited[i]){
                isVisited[i]=true;
                myQueue.add(i);
            }
        }
        if (!myQueue.isEmpty()) {
            bfs(myQueue.poll());
        }
    }
}