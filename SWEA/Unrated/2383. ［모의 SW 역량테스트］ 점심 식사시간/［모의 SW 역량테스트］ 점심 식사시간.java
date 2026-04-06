import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int n;
    private static int min;
    private static List<int[]> p;
    private static List<int[]> s;
    private static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            p = new ArrayList<>();
            s = new ArrayList<>();
            time = new int[2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        p.add(new int[]{k, j}); // x, y 좌표 삽입
                    }
                    if (x >= 2) {
                        time[s.size()] = x;
                        s.add(new int[]{k, j});
                    }
                }
            }
            solve();
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        for (int i = 0; i < (1 << p.size()); i++) {
            List<int[]> setA = new ArrayList<>();
            List<int[]> setB = new ArrayList<>();
            for (int j = 0; j < p.size(); j++) {
                if ((i & (1 << j)) == 0) {
                    setA.add(p.get(j));
                } else {
                    setB.add(p.get(j));
                }
            }
            // 계산로직 A는 1번 계단, B는 2번 계단
            int sum = Math.max(calc(setA, 0), calc(setB, 1));
            min = Math.min(min, sum);
        }
    }

    private static int calc(List<int[]> set, int stairNum) {
        if (set.isEmpty()) {
            return 0;
        }
        int[] stair = s.get(stairNum);
        int length = time[stairNum];

        List<Integer> arrivalTime = new ArrayList<>();
        for (int[] pos : set) {
            int dist = Math.abs(stair[0] - pos[0]) + Math.abs(stair[1] - pos[1]);
            arrivalTime.add(dist);
        }
        Collections.sort(arrivalTime);

        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for (int time : arrivalTime) {
            int ready = time + 1;
            if (q.size() == 3) {
                int out = q.poll();
                ready = Math.max(ready, out);
            }

            int finish = ready + length;
            q.add(finish);
            last = finish;
        }

        return last;
    }
}