import java.util.Scanner;

public class A9{
	public static void main(String[] args){
		Scanner kbd = new Scanner(System.in);
		long n = kbd.nextLong();
		long k = kbd.nextLong();
		
		long winners = n/2;
		long dip = winners / (k+1);
		long c = dip*k;
		System.out.println(dip + " " + c + " " + (n - dip - c));
	}
}
