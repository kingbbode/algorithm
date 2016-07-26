package problem1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        st = new StringTokenizer(in.readLine());
        int now = 0;
        int move = 0;
        for (int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken());
            int right;
            int left;
            int s = q.size();
            int x = q.indexOf(index);
            if (x >= now) {
                right = x - now;
                left = s - right;
            } else {
                left = now - x;
                right = s - left;
            }
            if (right <= left) {
                now += right;
                move += right;
                if (now >= s) now = now - s;
            } else {
                now -= left;
                move += left;
                if (now < 0) now = s + now;
            }
            q.remove(now);
        }
        System.out.println(move);
    }
}
