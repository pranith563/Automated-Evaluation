import java.io.*;
import java.util.*;
public class A3
{	
    public static void main(String args[]) throws IOException
    {
    	Scanner s=new Scanner(System.in);
    	long n=s.nextLong();
    	long k=s.nextLong();
    	long d,rem;
    	if(k>=n/2) {
    		System.out.println("0 0 "+ n);
    		System.exit(0);
    	}
    	long min=n/2;
    	if(min%(k+1)==0) {
    		d=min/(k+1);
    		System.out.println(d+" "+(d*k)+" "+(n-(d*(1+k))));
    		System.exit(0);
    	}
    	else {
    		rem=min%(k+1);
    		min=min-rem;
    		if(min%(k+1)==0) {
        		d=min/(k+1);
        		System.out.println(d+" "+(d*k)+" "+(n-(d*(1+k))));
        		System.exit(0);
        	}
    	}
    	
    	System.out.println("0 0 "+n);
    	
    }
}
