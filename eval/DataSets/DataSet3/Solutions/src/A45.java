import java.util.Scanner;

public class A45 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long d = n/(2L*(k+1L));
		long c = k*d;
		long nw = n - d - c;
		System.out.print(d + " " + c + " " + nw);
		System.out.println();
		sc.close();
	}
}
