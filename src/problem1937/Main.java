package problem1937;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] m = new int[n][n];
        int[][] d = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                m[i][j] = scan.nextInt();
            }
        }
        int r = 1;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(d[i][j]==0) {
                    r = Math.max(r, search(m, d, i, j, n));
                }
            }
        }
        System.out.print(r);
    }
    static int search(int[][] m, int[][] d, int i, int j, int n){
        int r = 0;
        if(i>0&&m[i-1][j]>m[i][j]){
            r = Math.max(r,d[i-1][j]!=0?d[i-1][j]: search(m, d, i-1, j, n));
        }
        if(i<n-1&&m[i+1][j]>m[i][j]){
            r = Math.max(r,d[i+1][j]!=0?d[i+1][j]: search(m, d, i+1, j, n));
        }
        if(j>0&&m[i][j-1]>m[i][j]){
            r = Math.max(r,d[i][j-1]!=0?d[i][j-1]: search(m, d, i, j-1, n));
        }
        if(j<n-1&&m[i][j+1]>m[i][j]){
            r = Math.max(r,d[i][j+1]!=0?d[i][j+1]: search(m, d, i, j+1, n));
        }
        d[i][j]=1+r;
        return 1+r;
    }
}
