import java.util.*;
public final class A20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		
		long d = n/(2*(k+1));
		long c = k*d;
		long w= n-c-d; 
		System.out.print(d+" "+c+" "+w);

	}

}
