import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class A12 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int n = in.nextInt();


            for (int k2 = 1; k2 <= Math.sqrt(2 * n); k2++) {

                int right = (n - (k2 * (k2 + 1)) / 2) * 2;
                int lo = 1, hi = (int) Math.sqrt(right) + 1;
                while (hi - lo > 1) {
                    int mi = lo + (hi - lo) / 2;
                    int sum = mi * (mi + 1);
                    if (sum <= right) {
                        lo = mi;
                    } else hi = mi;
                }

//            System.out.format("k1=%d,k2=%d, right=%d\n", lo, k2, right);

                if (lo * (lo + 1) == right) {
                    out.print("YES");
                    return;
                }
            }

            out.print("NO");
        }

    }
}

