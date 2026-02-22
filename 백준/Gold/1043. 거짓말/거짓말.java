import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        ArrayList<Integer> know = new ArrayList<>();
        ArrayList<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();  // 파티 초기화
        }
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int tp = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tp; i++) {
            int x = Integer.parseInt(st.nextToken());
            know.add(x);
            union(0, x);  // 진실을 아는사람은 0애 union
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pp = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            parties[i].add(idx);
            for (int j = 1; j < pp; j++) {
                int x = Integer.parseInt(st.nextToken());
                // 파티에 참여한 사람을 같은 그룹으로 묶음
                union(idx, x);
                parties[i].add(x);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int x : parties[i]) {
                if (find(x) == find(0)) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}
