import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A47 {

	static Scanner in = new Scanner(System.in);

	static int n, x;
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws IOException {
		long n = in.nextLong(), k = in.nextLong();
		long dip = n / (2 * (k + 1));
		long cert = dip * k;
		long noWin = n - dip - cert;
		System.out.println(dip + " " + cert + " " + noWin);
	}
}
