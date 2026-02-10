import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int start=0;
        int end=m;
        int ans=0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum=0;
            for (int i = 1; i <= n; i++) {
                sum += Math.min(middle/i,n);
            }
            if (sum < m) {
                start=middle+1;
            } else{
                ans = middle;
                end=middle-1;
            }
        }
        System.out.println(ans);
    }
}
