import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int p =sc.nextInt();
        int s =sc.nextInt();
        sc.nextLine();
        int windowCount=0;
        int ia,ic,ig,it;
        int a=0,c=0,g=0,t=0;
        int count=0;
        String string = sc.nextLine();
        ia = sc.nextInt();
        ic = sc.nextInt();
        ig = sc.nextInt();
        it = sc.nextInt();
        for (int i = 0; i <p; i++) {
            if(string.charAt(i)=='A'){
                a++;
            } else if (string.charAt(i)=='C') {
                c++;
            } else if (string.charAt(i)=='G') {
                g++;
            } else if (string.charAt(i)=='T') {
                t++;
            }
            windowCount++;
            if(windowCount>=s+1){
                windowCount--;
                if(string.charAt(i-s)=='A'){
                    a--;
                } else if (string.charAt(i-s)=='C') {
                    c--;
                } else if (string.charAt(i-s)=='G') {
                    g--;
                } else if (string.charAt(i-s)=='T') {
                    t--;
                }
            }
            if (a >= ia && c >= ic && g >= ig && t >= it && windowCount==s) {
                count++;
            }
        }
        System.out.println(count);
    }

}
