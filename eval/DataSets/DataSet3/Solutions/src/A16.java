//package A;

import java.util.Scanner;

public class A16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long loosers = n%2!=0? n/2+1: n/2;
		long winners = n - loosers;
		long diplomas = winners/(k+1);
		long certificate = diplomas *k;
		loosers += winners -(diplomas + certificate);
		System.out.println(diplomas +" "+ certificate +" "+ loosers);
	}
}
