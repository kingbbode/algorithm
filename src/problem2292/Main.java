package problem2292;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        int s = 0, c = 1;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int e = Integer.parseInt(in.readLine()) - 1;
        while ((s * 6) < e) {
            s += c;
            c++;
        }
        System.out.println(c);
    }
}
