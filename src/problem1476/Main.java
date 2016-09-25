package problem1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int c = 0, r;
        while (true) {
            r = (c * 28) + S;
            if ((r - E) % 15 == 0 && (r - M) % 19 == 0) {
                break;
            }
            c++;
        }
        System.out.println(r);
    }
}
