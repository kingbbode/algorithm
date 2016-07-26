package problem1021;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int now = 0;
        int move = 0;
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            int x = q.indexOf(Integer.parseInt(st.nextToken()));
            int m = Math.abs(x - now);
            move += Math.min(m, q.size() - m);
            q.remove(x);
            now = x;
        }
        System.out.println(move);
    }
}
