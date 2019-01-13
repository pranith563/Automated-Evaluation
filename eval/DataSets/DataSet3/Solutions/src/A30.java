import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;

public class A30 {

    public static void main(String[] args) throws Exception {
        A30 solution = new A30();
        solution.run();
    }


    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        long n = Long.parseLong(tokenizer.nextToken());
        long k = Long.parseLong(tokenizer.nextToken());

        long p = 0;
        long d = 0;
        long w = n;
        if (n/(2*(k+1))>0){
            p = n/(2*(k+1));
            d = p * k;
            w = n - p - d;
        }


        printWriter.print(p + " " + d + " " + w);

        printWriter.close();

    }



}
