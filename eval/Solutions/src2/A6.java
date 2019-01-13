import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mouna Cheikhna
 */
public class A6 {
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
            long n = in.nextLong();

            Set<Long> set = new HashSet<>();
            long[] tn = new long[60000];
            for (int i = 1; i <= 60000; ++i) {
                tn[i - 1] = (long) i * (i + 1) / 2;
                set.add(tn[i - 1]);
            }

            for (int i = 0; i < 60000; i++) {
                long comp = n - tn[i];
                if (set.contains(comp)) {
                    out.println("YES");
                    return;
                }
            }

            out.println("NO");
        }

    }
}

