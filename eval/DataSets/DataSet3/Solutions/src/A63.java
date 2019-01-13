/*
ID: william177
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class A63 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long max_dip = (n / 2) / (k + 1);
		System.out.println(max_dip + " " + (max_dip * k) + " " + (n - (max_dip * (k+1))));
		sc.close();
	}
}
