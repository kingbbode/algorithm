package problem1021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            l.add(scan.nextInt());
        }
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        int now = 0;
        int move = 0;
        for (int i : l) {
            int right;
            int left;
            int s = q.size();
            int x = q.indexOf(i);
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
