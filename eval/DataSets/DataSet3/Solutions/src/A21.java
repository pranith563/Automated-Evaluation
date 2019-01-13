import java.util.Scanner;

public class A21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n,k,d,c,w;
		Scanner in = new Scanner(System.in);
		n=in.nextLong();
		k=in.nextLong();
		d=Math.floorDiv(Math.floorDiv(n, 2), k+1);
		c=k*d;
		w=d+c;
		System.out.println(""+d+" "+c+" "+(n-w));
		in.close();
	}

}
