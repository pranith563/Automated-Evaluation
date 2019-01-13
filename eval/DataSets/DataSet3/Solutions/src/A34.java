import java.util.Scanner;

public class A34 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();
		long k = scn.nextLong();

		long n1 = n / 2;

		long d = n1 / (k + 1);
		long c = k * d;
		long left = n - d - c;

		System.out.println(d + " " + c + " " + left);

	}

}
