
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(start==1){
                System.out.println(s[end-1]);
            }else{
                System.out.println(s[end-1]-s[start-2]);
            }

        }
    }
}
