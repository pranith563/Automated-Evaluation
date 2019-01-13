import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class A38 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		String[] s = br.readLine().split(" ");
		long n = Long.parseLong(s[0]), k = Long.parseLong(s[1]);
		long num = n/(2*(k+1));
		pw.println(num + " " + (num*k) + " " + (n - num*(k+1)));
		pw.flush();
		pw.close();
	}
}
