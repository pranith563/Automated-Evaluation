import java.util.*;
public class A60
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long k=sc.nextLong();
		long r=((long)Math.floor(n/2))%(k+1);
		long u=(((long)Math.floor(n/2))-r)/(k+1);
		System.out.print(u+" "+k*u+" "+(n-u-k*u));
	}
}
