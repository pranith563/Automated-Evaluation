import java.util.Scanner;

public class A73 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        long n = s.nextLong(), k = s.nextLong();
        long diploma = n/(2*(k+1));
        long certifica = diploma*k;
        long nothing = n - (diploma +certifica);
        System.out.println(diploma + " " + certifica + " " + nothing);
    }
}
