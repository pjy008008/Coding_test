import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    public static void dfs(int v, int numCount) {
        if (numCount==n){
            if (isPrime(v)) {
                System.out.println(v);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(v * 10 + i)) {
                dfs(v * 10 + i, numCount+1);
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
