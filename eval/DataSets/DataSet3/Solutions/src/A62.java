import java.util.Scanner;

public class A62 {

	public static void main(String[] args) {
		new A();
	}

	A() {
		
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong(), k = in.nextLong();
		long d = n/(2*(k+1));
		
		System.out.printf("%d %d %d\n",d,k*d,n-(k+1)*d);
		
		in.close();

	}
	
}

/*

18 2

9 10

1000000000000 5

1000000000000 499999999999

 */









