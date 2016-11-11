package problem1003;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] zM = new int[41];
        int[] oM = new int[41];
        zM[0]=1;
        oM[1]=1;
        for(int s=1;s<40;s++){
            zM[s+1]=zM[s] + zM[s -1];
            oM[s+1]=oM[s] + oM[s -1];
        }
        int N = scan.nextInt();
        int[] T = new int[N];

        for(int i=0;i<N;i++){
            T[i] = scan.nextInt();
        }
        for(int t : T){
            System.out.println(zM[t] + " " + oM[t]);
        }
    }
}