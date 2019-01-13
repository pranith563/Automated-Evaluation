import java.io.*;
import java.util.*;

public class A35 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		Task task = new Task();
		int t = 1;
		for (int i = 1; i <= t; i++) task.solve(i, in, out);
		out.close();
	}

	static class Task {
		
		public void solve(int testNumber, InputReader in, OutputWriter out) throws IOException {
			long n = in.nextLong(), k = in.nextLong();
			long win = n / 2, a = win / (k + 1), b = a * k;
			out.println(a, b, n - a - b, " ");
 		}
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		private void tokenize() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		public String next() {
			tokenize();
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public char nextChar() {
			return next().charAt(0);
		}
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int size, int a) {
			tokenize();
			int[] arr=new int[size];
			for(int i = a; i < size; i++) {
				tokenize();
				arr[i] = Integer.parseInt(tokenizer.nextToken());
			}
			return arr;
		}
		
		public long[] nextLongArray(int size, int a) {
			tokenize();
			long[] arr=new long[size];
			for(int i = a; i < size; i++) {
				tokenize();
				arr[i] = Long.parseLong(tokenizer.nextToken());
			}
			return arr;
		}
		
		public float[] nextFloatArray(int size, int a) {
			tokenize();
			float[] arr=new float[size];
			for(int i = a; i < size; i++) {
				tokenize();
				arr[i] = Float.parseFloat(tokenizer.nextToken());
			}
			return arr;
		}

		public double[] nextDoubleArray(int size, int a) {
			tokenize();
			double[] arr=new double[size];
			for(int i = a; i < size; i++) {
				tokenize();
				arr[i] = Double.parseDouble(tokenizer.nextToken());
			}
			return arr;
		}

		public String[] nextStringArray(int size, int a) throws IOException {
			String[] arr=new String[size];
			for(int i = a; i < size; i++) 
				arr[i] = reader.readLine();
			return arr;
		}

		public char[] nextCharArray() throws IOException {
			return reader.readLine().toCharArray();
		}
	}

	static class OutputWriter {
		public PrintWriter pw;

		public OutputWriter(OutputStream stream) {
			pw = new PrintWriter(stream);
		}
		
		public void println(Object... obj) {
			if (obj.length == 0) pw.println();
			else {
				String delimiter = (String) obj[obj.length - 1];
				for (int i = 0 ; i < obj.length - 1; i++) pw.print(obj[i] + delimiter);
			}
		}

		public void close() {
			pw.close();
		}

		public void flush() {
			pw.flush();
		}

		public void printStringArray(String[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.println(arr[i]);
		}
		
		public void printBooleanArray(boolean[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}

		public void printIntArray(int[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}

		public void printLongArray(long[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}

		public void printCharArray(char[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}

		public void printFloatArray(float[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}

		public void printDoubleArray(double[] arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr[i] + " ");
		}
		
		public void printIntArrayList(ArrayList<Integer> arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr.get(i) + " ");
		}
		
		public void printLongArrayList(ArrayList<Long> arr, int a, int b) {
			for(int i = a; i < b; i++)
				pw.print(arr.get(i) + " ");
		}
	}
}
