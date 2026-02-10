import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        StringBuilder outStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int x=1;
        for(int i=0;i<n;i++){
            if(arr[i]>=x){
                while(arr[i]>=x){
                    stack.push(x);
                    outStr.append("+\n");
                    x++;
                }
                stack.pop();
                outStr.append("-\n");
            }else{
                int popValue = stack.pop();
                outStr.append("-\n");
                if (popValue != arr[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(outStr);
    }
}
