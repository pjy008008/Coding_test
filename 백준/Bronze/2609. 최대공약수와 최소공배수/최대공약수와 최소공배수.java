import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = euclidean(a, b);
        System.out.println(x);
        int temp = x;
        int weight = 1;
        while (temp % a != 0 || temp % b != 0) {
            temp = x * weight;
            weight++;
        }
        System.out.println(temp);
    }

    private static int euclidean(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return euclidean(b, r);
    }
}