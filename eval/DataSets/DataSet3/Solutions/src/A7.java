import java.io.*;
import java.util.*;

public class A7{
	public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       long n = sc.nextLong();
       long k = sc.nextLong();

       long nd = (n/2)/(k+1);
       long nc = k*(nd);
       long sum=0;
       sum = n-(nc+nd);
       System.out.println(nd+" "+nc+" "+sum);
	}
}
