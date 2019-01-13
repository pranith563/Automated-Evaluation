import java.util.Scanner;

public class A11 {
	public static void main (String args[]) {
		Scanner sc = new Scanner (System.in);
		long n = sc.nextLong() * 2;
		long t = 1, r = 1, k = 1;
		int flag = 0;
		for (long i = 1; i * i <= n; i++) {
			t = (i * (i + 1));
			r = n - t;
			k = (long) Math.sqrt(r);
			t = (k * (k + 1));
			if (t == r && k > 0) {
				System.out.println("YES");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("NO");
		}
	}
}

		 	 	 	 	 					 	 		 	    	 	
