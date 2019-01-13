import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A66 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
//        InputStream inputStream = new FileInputStream("sum.in");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("sum.out");


//        Path path = Paths.get(URI.create("file:///foo/bar/Main.java"));
//        System.out.print(path.getName(200));

//        Path p = Paths.get("/foo/bar/Main.java");
//        for (Path e : p) {
//            System.out.println(e);
//        }

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Answer solver = new Answer();
        solver.solve(in, out);
        out.close();
    }
}

class Answer {
    private final int INF = (int) (1e9 + 7);
    private final int MOD = (int) (1e9 + 7);
    private final int MOD1 = (int) (1e6 + 3);
    private final long INF_LONG = (long) (1e18 + 1);


    public void solve(InputReader in, PrintWriter out) throws IOException {

        long n = in.nextLong();
        long k = in.nextLong();

        long x = n / (2 * (k + 1));

        long a = x;
        long b = k * x;
        long c = n - a - b;

        out.print(a + " " + b + " " + c);
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
