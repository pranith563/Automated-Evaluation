import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class A59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		A solver = new A();
		solver.solve(1, in, out);
		out.close();
	}

}

class A {
	public void solve(int cas, InputReader in, PrintWriter out) {
		long n = in.nextLong(), k = in.nextLong();
		long a = n / 2 / (k+1), b = a * k, c = n - a - b;
		out.println(a + " " + b + " " + c);
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	
	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	public Long nextLong() {
		return Long.parseLong(next());
	}
}
