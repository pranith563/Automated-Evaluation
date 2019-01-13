import java.util.*;

public class A7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
					
		while(sc.hasNext()) {
			long n = sc.nextLong();
			
			long i,a,b;
			boolean f = false;
			
			for(i=1;i<Math.sqrt(2*n);i++) {				
				a = i*(i+1)/2;
				
				long l=i, r=(long) Math.sqrt(2*n),mid=(l+r)/2;
				
				while(l<=r) {
					b = mid*(mid+1)/2;
					if(a+b<n) {
						l = mid+1;
						mid = (l+r)/2;
					}
					else if(a+b>n) {
						r = mid-1;
						mid = (l+r)/2;
					}
					else {
						f = true;
						break;
					}					
				}
				
				if(f)
					break;
			}
			
			if(f)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
					
	}

}

  					  	   		 				  		  	  	
