import java.io.*;
import java.util.*;

public class Solution {
    private static int[] tickets;
    private static int[] plans;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            tickets = new int[4];
            plans = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                tickets[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 12; j++) {
                plans[j] = Integer.parseInt(st.nextToken());
            }
            min = tickets[3];
            dfs(0, 0);
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int cost) {
        if (idx >= 12) {
            min = Math.min(min, cost);
            return;
        }

        int days = plans[idx];
        if (plans[idx] == 0) {
            dfs(idx + 1, cost);
        } else {
            dfs(idx + 1, cost + tickets[0] * days);
            dfs(idx + 1, cost + tickets[1]);
            dfs(idx + 3, cost + tickets[2]);
        }
    }
}