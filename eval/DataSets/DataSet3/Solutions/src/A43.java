

import java.util.Scanner;

public class A43 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] array = in.nextLine().split(" ");
		long n = Long.parseLong(array[0]);
		long k = Long.parseLong(array[1]);
		
		long maxWinner = n / 2;
		long dip = maxWinner / (k + 1);
		long cer = dip * k;
		System.out.println(dip + " " + cer + " " + (n - dip - cer));
		
		in.close();
	}
}
