import java.io.*;
import java.util.*;

public class A42 {
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        long n = Long.parseLong(s.split(" ")[0]);
        long k = Long.parseLong(s.split(" ")[1]);
        long a = (n/2)/(k+1);
        long b = a*k;
        System.out.println(a+" "+b+" "+((a==0)?n:n-a-b));
    }
}
