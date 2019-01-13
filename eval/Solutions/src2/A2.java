import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class A2 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ProblemAFunkyNumbers solver = new ProblemAFunkyNumbers();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemAFunkyNumbers {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 123456;
            HashSet<Long> triangularNumbers = new HashSet<>();
            for (int i = 1; i < MAX; i++) triangularNumbers.add(((long) i * (i + 1)) / 2);
            long n = in.nextInt();
            for (long triangularNumber : triangularNumbers) {
                if (triangularNumbers.contains(n - triangularNumber)) {
                    out.println("YES");
                    return;
                }
            }
            out.println("NO");
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

