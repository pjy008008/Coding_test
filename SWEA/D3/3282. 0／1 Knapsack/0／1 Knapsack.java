import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] dp = new int[k + 1];
            int[][] thing = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                thing[j][0] = Integer.parseInt(st.nextToken()); // volume
                thing[j][1] = Integer.parseInt(st.nextToken()); // value
            }
            for (int j = 0; j < n; j++) {
                for (int p = k; p > thing[j][0] - 1; p--) {
                    dp[p] = Math.max(dp[p], dp[p - thing[j][0]] + thing[j][1]);
                }
            }
            sb.append("#").append(i).append(" ").append(dp[k]).append("\n");
        }
        System.out.println(sb);
    }
}
