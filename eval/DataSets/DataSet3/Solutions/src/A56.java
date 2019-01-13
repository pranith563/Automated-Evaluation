import java.util.Scanner;

public class A56{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong(), k = in.nextLong();
		long a = n / ((k<<1) + 2);		
		System.out.print(a + " " + k * a + " " + (n - (k + 1) * a));
		in.close();
	}
}
