import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A8 {

    public static void main(String[] args) throws IOException {
        ReaderA.init(System.in);
        long n = (long) ReaderA.nextInt();
        int m = 1;
        long M = m*m + m;
        boolean can = false;
        while (M < 2*n) {
            int k = (((int) Math.sqrt(8*n - 4*M + 1.0)) - 1)/2;
//            if (m == 43245) System.out.println(k);
            if (M + k*k + k == 2*n) {
                can = true;
                break;
            }
            m++;
            M = m*m + m;
        }
        System.out.println(can ? "YES":"NO");
    }
}

/**
 * Reader class based on the article at "https://www.cpe.ku.ac.th/~jim/java-io.html"
 */
class ReaderA {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    static void init(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }

    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

//    static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//
//    //    Get a whole line.
//    static String line() throws IOException {
//        return reader.readLine();
//    }
//
//    static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
}

