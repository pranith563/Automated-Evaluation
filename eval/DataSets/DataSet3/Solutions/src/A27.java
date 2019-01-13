import java.util.Scanner;
import java.io.IOException;

/**
 * Created by Shoumik on 01-Aug-17.
 */

public class A27 {
    public static void main(String [] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        long i, n=sc.nextLong(), k=sc.nextLong();



        for(i=n/2/(k+1); i>=0; i--)
        {

            if (i*(k+1)<=n/2)
            {
                    System.out.println(i+ " "+ k*i +" "+ (n-i*(k+1)));
                    break;
            }
        }


    }

}
