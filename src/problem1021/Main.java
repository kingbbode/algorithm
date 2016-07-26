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

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        int move = 0;
        for (int i : l) {
            int cnt = 0;
            for (int j : q) {
                if (j == i) break;
                cnt++;
            }
            int s = q.size();
            boolean isLeft = (s / 2) >= cnt;
            int c = isLeft ? cnt : s - cnt;
            for (int k = 0; k < c; k++) {
                if (isLeft) q.addLast(q.pop());
                else q.addFirst(q.pollLast());
            }
            move += c;
            q.pop();
        }
        System.out.println(move);
    }
}
