package problem1021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < M; i++) {
            list.add(scan.nextInt());
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        int goal = M;
        int move = 0;
        while (goal > 0) {
            int cntDouble = -1;
            int cntLeft = 0;
            int cntRight = 0;
            Iterator<Integer> q0 = q.iterator();
            boolean before = false;
            while (q0.hasNext()) {
                boolean now = list.contains(q0.next());
                if(before && now){
                    break;
                }
                before = now;
                cntDouble++;
            }
            Iterator<Integer> q1 = q.iterator();
            while (q1.hasNext()) {
                if (list.contains(q1.next())) {
                    break;
                }
                cntLeft++;
            }

            Iterator<Integer> q2 = q.descendingIterator();
            while (q2.hasNext()) {
                if (list.contains(q2.next())) {
                    break;
                }
                cntRight++;
            }
            if (cntDouble <= cntLeft) {
                while (cntDouble > 0) {
                    q.addLast(q.pop());
                    move++;
                    cntDouble--;
                }
            } else if (cntLeft <= cntRight) {
                while (cntLeft > 0) {
                    q.addLast(q.pop());
                    move++;
                    cntLeft--;
                }
            } else {
                while (cntRight >= 0) {
                    q.addFirst(q.pollLast());
                    move++;
                    cntRight--;
                }
            }
            q.pop();
            goal--;
        }
        System.out.println(move);
    }
}
