/*
ID: mchensd
LANG: JAVA
PROG: DiplomasAndCertificates
 */

/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;

public class A55 {
    long n, k;
    
    public boolean can(long dip) {
        return ( dip <= n/(2*(k+1)));
    }
    public void run(BufferedReader br, PrintWriter pw) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        
        long lb = 0;
        long ub = n/4;
        
        while (true) {
            if (lb == ub) break;
            long xs = (lb + ub + 1) / 2;
            if (can(xs)) lb = xs;
            else ub = xs - 1;
        }
        pw.printf("%d %d %d\n", lb, lb*k, n - ((k+1)*lb));
    }
    public static void main(String[] args) throws IOException {
//        new DiplomasAndCertificates().runFileIO("DiplomasAndCertificates");
        new A55().runStdIO();

    }
    
    public void runFileIO(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename + ".out")));
        run(br, pw);
        pw.close();
    }

    public void runStdIO() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        run(br, pw);
        pw.close();
    }
}

