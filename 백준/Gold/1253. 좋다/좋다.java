import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            long goodNum = arr[i];
            int startIndex = 0;
            int endIndex=n-1;
            while (startIndex < endIndex) {
                long sum = arr[startIndex]+arr[endIndex];
                if(startIndex==i){
                    startIndex++;
                    continue;
                }else if(endIndex==i){
                    endIndex--;
                    continue;
                }
                if(sum==goodNum){
                    count++;
                    break;
                }
                if(sum>goodNum){
                    endIndex--;
                }else if(sum<goodNum){
                    startIndex++;
                }
            }
        }
        System.out.println(count);
    }
}
