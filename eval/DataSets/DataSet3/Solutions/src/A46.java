import java.util.Scanner;

public class A46 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long d = n/(2L*(k+1L));
		long c = k*d;
		long nw = n - d - c;
		System.out.println(d + " " + c + " " + nw);
		sc.close();
	}
}
