import java.util.*;
import java.io.*;
import java.math.*;

public class A5 {

    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long n = input.nextLong();
        long k = input.nextLong();
        long winners = n / 2;
        long topWinners = winners / (k + 1);
        long lowWinners = topWinners * k;
        System.out.println(topWinners + " " + lowWinners + " " + (n - lowWinners - topWinners));
    }
}
