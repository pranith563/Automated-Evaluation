//package TIM2;


import java.io.*;
import java.util.*;

public class A22 {
    static Scanner input = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        long n = input.nextLong();
        long k = input.nextLong();
        long dip = (n / 2) / (k + 1), cer = 0, num = 0;
        cer = k * dip;
        num = n - dip - cer;
        System.out.println(dip + " " + cer + " " + num);
    }
}
