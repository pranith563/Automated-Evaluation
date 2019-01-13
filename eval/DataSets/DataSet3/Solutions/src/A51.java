import java.io.*;
import java.util.*;

/**
 * Road to 1800 raiting
 */
public class A51{
    static class Task {
        PrintWriter out;

        long n, k;

        public void solve(MyScanner in, PrintWriter out) {
            n = in.nextLong();
            k = in.nextLong();

            long rk = binsearch(0, n + 1);
            System.out.println(rk + " " + k * rk + " " + (n - rk * (k + 1)));
        }

        long binsearch(long l, long r) {
            if (l == r - 1) {
                return l;
            }
            long mid = l + (r - l) / 2;

            if (isInRange(mid)) {
                return binsearch(mid, r);
            } else {
                return binsearch(l, mid);
            }
        }

        boolean isInRange(long a) {
            try {
                return Math.addExact(Math.multiplyExact(a, k), a) <= n / 2;
            } catch (ArithmeticException e) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

