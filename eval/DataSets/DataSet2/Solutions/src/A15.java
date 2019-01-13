import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A15 {
	static MyScanner in = new MyScanner();
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) {
		boolean can = false;
		long n = in.nextInt();
		long[] arr = new long[1000000];
		for (long i = 1; i <= arr.length; i++) {
			arr[(int) i - 1] = (i * (i + 1)) / 2;
		}
		int j = arr.length - 1;
		for (int i = 0; i <= j; i++) {
			while (j > 0 && arr[i] + arr[j] > n) {
				j--;
			}
			if (arr[i] + arr[j] == n) {
				can = true;
			}
		}
		out.println(can ? "YES" : "NO");
		/*
		 * Dont delete
		 */
		out.close();
		/*
		 * 
		 */
	}

	// BIN seach
	// while (l != r) {
	// mid = (l + r) / 2;
	// if (check(mid)) {
	// ans = mid;
	// l = mid + 1;
	// } else {
	// r = mid;
	// }
	// }
	public static long GCD(long a, long b) {
		return b == 0 ? a : GCD(b, a % b);
	}

	public static long LCM(long a, long b) {
		return a * b / GCD(a, b);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
