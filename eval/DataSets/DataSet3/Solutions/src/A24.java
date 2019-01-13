import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author captainTurtle
 */
public class A24 {
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
            long k = in.nextLong();
            long n = in.nextLong();
            long g = 0, w = 0, s = 0, sabit = k;


            g = (sabit / 2) / (n + 1);
            w = g * n;
            s = sabit - (g + w);
            System.out.println(g);
            System.out.println(w);
            System.out.println(s);

        }

    }
}

