import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max=0;
        double total=0;
        double average;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x > max) {
                max=x;
            }
            arr[i]=x;
        }
        for (int i = 0; i < n; i++) {
            total += ((double)arr[i]/max*100);
        }
        average = total/n;
        System.out.println(average);
    }
}
