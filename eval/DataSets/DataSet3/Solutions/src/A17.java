import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by sbabkin on 9/14/2015.
 */
public class A17 {

    BufferedReader br;
    PrintWriter pw;
    StringTokenizer stok;

    private String nextToken() throws IOException {
        while (stok==null || !stok.hasMoreTokens()){
            stok = new StringTokenizer(br.readLine());
        }
        return stok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private void Run() throws IOException {
//        br=new BufferedReader(new FileReader("input.txt"));
//        pw=new PrintWriter("output.txt");
        br=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(new OutputStreamWriter(System.out));

        solve();
        pw.flush();
        pw.close();
    }

    private void solve() throws IOException {
        long n = nextLong();
        long k = nextLong();
        long mn = (n/2)/(k+1);
        pw.println(mn + " " + (mn*k) + " " + (n-mn*(k+1)));
    }

    public static void main(String[] args) throws IOException {
        new A17().Run();
    }

}
