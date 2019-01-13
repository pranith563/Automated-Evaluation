import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A26 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        long n = Reader.nextLong();
        long k = Reader.nextLong();
        long c = n/(2*(1 + k));
        System.out.println(c + " " + k*c + " " + (n - (k*c + c)));
    }
}

class Reader{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    static void init(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }
    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()){
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }

    //Get a whole line.
//    static String line() throws IOException{
//        return reader.readLine();
//    }
//
//    static double nextDouble() throws IOException{return Double.parseDouble(next());}
}
