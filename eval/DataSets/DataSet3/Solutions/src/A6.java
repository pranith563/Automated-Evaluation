import java.util.Scanner;

public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		long k = input.nextLong();
		long x=n/(2*(k+1));
		System.out.print(x+" ");
		System.out.print(k*x+" ");
		System.out.println(n-(k+1)*x +" ");
		
	}

}
