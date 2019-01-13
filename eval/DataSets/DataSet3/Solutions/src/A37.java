import java.util.Scanner;

public class A37 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long k=sc.nextLong();
		long x=n/(2*(k+1));
		long x1=k*x;
		long x3=n-x-x1;
		System.out.println(x+" "+x1+" "+x3 );
	
	
	}

}
