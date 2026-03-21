import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] thing = new int[n][2]; // cost, customer
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            thing[i][0] = Integer.parseInt(st.nextToken());
            thing[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[100001];
        for (int i = 0; i < n; i++) {
            int cost = thing[i][0];
            int customer = thing[i][1];
            for (int j = cost; j <= 100000; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost] + customer);
                if (dp[j] >= c) {
                    break;
                }
            }
        }
        for (int i = 0; i <= 100000; i++) {
            if(dp[i]>=c){
                System.out.println(i);
                break;
            }
        }
    }
}