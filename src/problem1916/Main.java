package problem1916;

import java.util.Scanner;

public class Main {
    public final static int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean v[] = new boolean[n];
        int d[] = new int[n];
        int p[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            d[i] = INF;
            for(int j = 0 ; j < n ; j++){
                p[i][j] = INF;
            }
        }
        int m = sc.nextInt();
        for(int i=0; i<m;i++){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int dist = sc.nextInt();
            int sv = p[start][end];
            p[start][end] = sv==0?dist:(sv>dist?dist:sv);
        }
        int s = sc.nextInt() - 1;
        d[s] = 0;
        int e = sc.nextInt() - 1;
        int min;
        int node = 0;
        for(int i=0; i< n; ++i){
            min = INF;
            for(int j=0; j<n; ++j){
                if(min > d[j] && !v[j]){
                    min = d[j];
                    node = j;
                }
            }
            if(node == e){
                break;
            }
            v[node] = true;
            for(int k= 0; k<n; ++k){
                if(!v[k]){
                    if(min+p[node][k] < d[k]){
                        d[k] = min+p[node][k];
                    }
                }
            }
        }
        System.out.println(d[e]);
    }
}
