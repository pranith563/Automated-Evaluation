import java.io.*;
import java.util.*;
public class A68
{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		long k = scn.nextLong();
		long d = n / (2 * (1 + k));
		long c,l;
		c = k * d;
		l = n - c - d;
		scn.close();
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(d + " " + c + " " + l);
		pw.close();
	}
}
