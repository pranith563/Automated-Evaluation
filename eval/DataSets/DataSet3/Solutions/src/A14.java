import java.util.Scanner;

public class A14 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("");
        long n = in.nextLong();
        long k = in.nextLong();
                
        System.out.println((n/2/(k+1)) +" "+ (n/2/(k+1))*k +" "+ (n-(n/2/(k+1))-((n/2/(k+1))*k)));
        
    }
    
}
