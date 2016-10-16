package problem2293;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] v = new int[n];
        int[] dp = new int[k+1];
        for(int i=0;i<n;i++){
            v[i] = scan.nextInt();
        }
        dp[0]=1;
        for(int i : v){
            for(int j=i;j<=k;j++){
                dp[j] += dp[j-i];
            }
        }
        System.out.println(dp[k]);
    }
}
