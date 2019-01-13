
import java.util.*;

public class A18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long dip = 0;
        long gram = 0;
        long nothing = 0;

        dip = n / (2 * (k + 1));
        gram = dip * k;
        nothing = n - gram - dip ;
        System.out.println(dip + " " + gram + " " + nothing);
    }
}
