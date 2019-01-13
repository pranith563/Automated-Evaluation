import java.util.*;
public class A41 {
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		long a=reader.nextLong();
		long b=reader.nextLong();
		long mid=0;
		mid=a/2;
		long n=0;
		if(mid%(b+1)==0){
			mid=mid/(b+1);
			n=1;
		}
		else if(mid<b+1){ 
			mid--;
		}
		else{
			mid=(mid-mid%(b+1))/(b+1);
			n=1;
		}
		
		if(n==0){
			System.out.println(0+" "+0+" "+a);
		}
		else{
			System.out.println(mid+" "+(mid*b)+" "+(a-mid*(b+1)));
		}
		//System.out.println(mid);
		
	}
}
   	 	 		 	  	       				 			 	
