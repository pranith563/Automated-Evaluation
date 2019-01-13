import java.io.FileReader;
import java.util.Scanner;

public class A50{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long total = scanner.nextLong();
        long k = scanner.nextLong();

        long diplomas = total / (2 * (k + 1));
        long gramotas = diplomas * k;
        long s_nosom = total - (diplomas + gramotas);

        System.out.println(diplomas + " " + gramotas + " " + s_nosom);
    }

}
