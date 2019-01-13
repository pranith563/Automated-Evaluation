
import java.util.Scanner;

public class A23 {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		long n = in.nextLong();
		long k = in.nextLong();
		long supposedWinners = n / 2;
		
		double partialWinners = (double) (supposedWinners/(k+1));
		
		long dip = (long)partialWinners;
		long cert = dip * k;
		
		System.out.println(dip + " " + cert + " " + (n - dip - cert));
	}

}
