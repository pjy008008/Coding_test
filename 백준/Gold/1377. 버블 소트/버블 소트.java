import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrObj[] arrObjs = new ArrObj[n];
        for (int i = 0; i < n; i++) {
            arrObjs[i] = new ArrObj(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arrObjs, new Comparator<ArrObj>() {
            @Override
            public int compare(ArrObj o1, ArrObj o2) {
                return Integer.compare(o1.valueNum,o2.valueNum);
            }
        });
        int max=0;
        for (int i = 0; i < n; i++) {
            if(max<(arrObjs[i].index-i)){
                max=arrObjs[i].index-i;
            }
        }
        System.out.println(max+1);
    }
    public static class ArrObj{
        public int index;
        public int valueNum;

        public ArrObj(int index, int valueNum) {
            this.index= index;
            this.valueNum=valueNum;
        }
    }
}
