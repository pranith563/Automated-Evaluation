/**
 * Created by Администратор on 23.05.2017.
 */
import java.util.*;
import java.lang.*;
public class A36 {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();
        long fakeN = n;
        fakeN /=2;
        if (fakeN <= k)
        {
            System.out.print("0 0 " + n);
            return;
        }
        fakeN /= k+1;
        System.out.print(fakeN);
        System.out.print(' ');
        System.out.print(fakeN*k);
        System.out.print(' ');
        System.out.print(n-(fakeN*(k+1)));
    }
}


