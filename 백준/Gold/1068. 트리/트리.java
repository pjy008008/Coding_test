import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] tree;
    static int delete;
    static boolean[] isVisit;
    static int leafCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x;
        int root=-1;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        isVisit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                root=i;
            }else{
                tree[i].add(x);
                tree[x].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        delete = Integer.parseInt(st.nextToken());
        dfs(root);
        if (delete == root) {
            System.out.println(0);
        }else{
            System.out.println(leafCount);
        }
    }

    public static void dfs(int v) {
        if (isVisit[v]) {
            return;
        }
        int nCount=0;
        isVisit[v]=true;
        for (int i : tree[v]) {
            if (!isVisit[i] && i != delete) {
                nCount++;
                dfs(i);
            }
        }
        if (nCount == 0) {
            leafCount++;
        }
    }

}