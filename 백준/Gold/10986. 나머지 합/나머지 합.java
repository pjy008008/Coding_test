import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long count=0;
        long[] s = new long[n];
        long[] c = new long[m];
        s[0]=scanner.nextInt();
        for (int i = 1; i < n; i++) {
            s[i]=s[i-1]+scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int r=(int)(s[i]%m);
            if(r==0){
                count++;
            }
            c[r]++;
        }
        for(int i=0;i<m;i++){
            long x;
            if(c[i]>=2){
                x=(c[i]*(c[i]-1))/2;
                count+=x;
            }
        }
        System.out.println(count);
    }
}
