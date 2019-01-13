import java.util.Scanner;

public class A33
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long k = scan.nextLong();
		long max = n/2;
		long d = max/(k+1);
		System.out.println(d + " " + d*k + " " + (n-(d+d*k)));
	}
}
