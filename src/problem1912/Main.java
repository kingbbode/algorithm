package problem1912;

/**
 * Created by YG-MAC on 2016. 10. 9..
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ms = -1001;
        int s = 0;
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt();
            if(s + v < 0){
                ms = Math.max(ms,s + v);
                s = 0;
            }else{
                s += v;
                ms = Math.max(ms,s);
            }
        }
        System.out.println(ms);
    }
}