import java.util.*;

public class A64 {
	static long n,k,m,a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		k = sc.nextLong();
		m = n;
		if (n%2!=0) m=n-1;
		m = m/2;
		a = (m - (m%(k+1)))/(k+1);
		if (a==0) {
			System.out.println(0 + " " + 0 + " " + n);
		}
		else {
			System.out.print(a + " " + a*k + " ");
			System.out.println(n-a*(k+1));
		}
	}
}
