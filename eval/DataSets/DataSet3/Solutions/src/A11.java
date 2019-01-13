import java.util.Scanner;
public class A11{
    public static void main(String[] args) {     
        Scanner input = new Scanner(System.in);
        long n=input.nextLong();
        long k=input.nextLong();
        
        long d= n/(2*(1+k));
        long c= d*k;
        long e= n-(c+d);
        System.out.println(d+" "+c+" "+e);
    }
}
// 1508272983217
