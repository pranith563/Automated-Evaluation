import java.io.*;
import java.util.*;

/**
 * Road to 1800 raiting
 */
public class A52{
    static class Task {
        PrintWriter out;

        public void solve(MyScanner in, PrintWriter out) {
            long n = in.nextLong(), k = in.nextLong();
            //rk + k * rk <= 2 / n
            long rk = n / 2 / (k + 1);
            System.out.println(rk + " " + k * rk + " " + (n - rk * (k + 1)));
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

