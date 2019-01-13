import java.io.*;
import java.util.*;

/**
 * Created by Nayan on 7/11/2017.
 */
public class A49 {
    public static void main(String[] args)throws IOException{
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new FileInputStream("input.txt"));
        long n = input.nextLong();
        long k = input.nextLong();
        long D, C, loser;
        loser = n/2;
        D = loser/(1+k);
        C = D*k;
        loser = n - (C+D);
        System.out.println(D+" "+C+" "+loser);

    }

    static class Scanner {
        private StringTokenizer st;
        private BufferedReader br;
        Scanner(InputStream s){br=new BufferedReader(new InputStreamReader(s));}
        String next() throws IOException {
            while(st==null||!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt()throws IOException{return Integer.parseInt(next());}
        long nextLong()throws IOException{return Long.parseLong(next());}
        String nextLine()throws IOException{return br.readLine();}
        double nextDouble()throws IOException{return Double.parseDouble(next());}
        boolean ready()throws IOException{return br.ready();}
    }
}
