import java.util.*;

public class A2{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a, b, i, j, c;
        a = s.nextLong();
        b = s.nextLong();
        i=a/(2*(b+1));
        System.out.println(i+" "+i*b+" "+(a-i*(b+1)));
    }
}
