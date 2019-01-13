import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Educational Codeforces Round 24
 * Problem A
 * Diplomas and Certificates
 *
 * Created by mcparadip on 7/9/17.
 */

public class A54 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long diploma = n / 2 / (k+1);
        long certificate = diploma * k;
        long none = n - diploma - certificate;

        System.out.println(diploma + " " + certificate + " " + none);


    }

}
