import java.util.*;

public class A29 
{  
    public static void main(String args [])
    {
        Scanner enter = new Scanner (System.in) ;
        long n = enter.nextLong() , k = enter.nextLong() , dip = 0 , cert = 0 , losers = n/2 ;
        losers = n/2 ;
        losers = losers /(k+1) ;
        dip = losers ;
        cert = dip * k ;
        losers = n - dip*(k+1) ;
        System.out.println(dip + " " + cert + " " + losers) ;
    }
}
