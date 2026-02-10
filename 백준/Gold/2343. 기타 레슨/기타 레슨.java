import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int low=0,high=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > low) {
                low = arr[i];
            }
            high += arr[i];
        }
        while (low <= high) {
            int medium = (high + low) / 2;
            int count=0;
            int sum=0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > medium) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > m) {
                low=medium+1;
            }else{
                high = medium - 1;
            }

        }
        System.out.println(low);
    }
}
