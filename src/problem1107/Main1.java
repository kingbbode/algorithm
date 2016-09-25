package problem1107;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws Exception {
        boolean[] B = new boolean[10];
        for (int i = 0; i < 10; i++) {
            B[i] = true;
        }
        Scanner scan = new Scanner(System.in);
        int O = scan.nextInt();
        int BC = scan.nextInt();
        for (int i = 0; i < BC; i++) {
            B[scan.nextInt()] = false;
        }
        int R = Math.abs(O - 100);
        if (O == 100) {
            R = 0;
        } else if (BC != 10) {
            for (int i = 0; i <= 1000000; i++) {
                boolean b = true;
                int t = i, l = 0;
                while (t > 0) {
                    if (!B[t % 10]) {
                        b = false;
                        break;
                    }
                    t /= 10;
                    l++;
                }
                if (i == 0) {
                    l = 1;
                    if (!B[0]){
                        b = false;
                    }
                }
                if (b) {
                    R = Math.min(R, Math.abs(O - i) + l);
                }
            }
        }
        System.out.println(R);
    }
}

