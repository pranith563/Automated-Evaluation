import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;

public class A4 {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	private PrintWriter pw;
	private long mod = 1000000000 + 7;

	private StringBuilder ans_sb;
	private int sum = 0;

	private void soln() {
		long n = nextLong();
		long k = nextLong();
		long cnt = n/(2*(k+1));
		
		pw.println(cnt+" "+cnt*k +" "+(n-cnt*(k+1)));
		
	}
	private class Bridge {
		private LinkedList<Edge>[] graph;
		private LinkedList<Integer>[] tree;
		private int t;
		private boolean[] isBridge;
		private int[] cno;

		public Bridge(int n, int m) {
			pre(n, m);
		}

		private class Edge {
			int u, v, i;

			public Edge(int a, int b, int c) {
				u = a;
				v = b;
				i = c;
			}
		}

		private void pre(int n, int m) {
			graph = new LinkedList[n];
			tree = new LinkedList[n];
			for (int i = 0; i < m; i++) {
				int u = nextInt() - 1;
				int v = nextInt() - 1;
				Edge e = new Edge(u, v, i);
				graph[u].add(e);
				graph[v].add(e);
			}
			isBridge = new boolean[m];
			cno = new int[n];
			boolean[] v = new boolean[n];
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				if (!v[i])
					dfs(i, null, v, arr);
		}

		private int dfs(int u, Edge e, boolean[] v, int[] arr) {
			v[u] = true;
			arr[u] = t++;
			int min = arr[u];
			Iterator<Edge> it = graph[u].listIterator();
			while (it.hasNext()) {
				Edge x = it.next();
				int w = x.u;
				if (x.u == u)
					w = x.v;
				if (!v[w])
					min = Math.min(min, dfs(w, x, v, arr));
				else if (x != e)
					min = Math.min(min, arr[w]);
			}
			if (min == arr[u] && e != null)
				isBridge[e.i] = true;
			return min;
		}

		private void bfs(int u, int cmpNo, Queue<Integer>[] q, boolean[] v) {
			int cur = cmpNo;
			cno[cur] = cmpNo;
			q[cur].add(u);
			v[u] = true;
			while (!q[cur].isEmpty()) {
				int x = q[cur].poll();
				Iterator<Edge> it = graph[x].listIterator();
				while (it.hasNext()) {
					Edge x1 = it.next();
					int w = x1.u;
					if (w == x)
						w = x1.v;
					if (!v[w]) {
						if (isBridge[x1.i]) {
							tree[cur].add(0, cmpNo + 1);
							tree[cmpNo + 1].add(0, cur);
							bfs(w, cmpNo + 1, q, v);
						} else {
							bfs(w, cmpNo, q, v);
						}
					}
				}
			}
		}
	}

	private String solveEqn(long a, long b) {
		long x = 0, y = 1, lastx = 1, lasty = 0, temp;
		while (b != 0) {
			long q = a / b;
			long r = a % b;
			a = b;
			b = r;
			temp = x;
			x = lastx - q * x;
			lastx = temp;
			temp = y;
			y = lasty - q * y;
			lasty = temp;
		}
		return lastx + " " + lasty;
	}

	private void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	private long pow(long a, long b, long c) {
		if (b == 0)
			return 1;
		long p = pow(a, b / 2, c);
		p = (p * p) % c;
		return (b % 2 == 0) ? p : (a * p) % c;
	}

	private long gcd(long n, long l) {
		if (l == 0)
			return n;
		return gcd(l, n % l);
	}

	public static void main(String[] args) throws Exception {
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				new A4().solve();
			}
		}, "1", 1 << 25).start();
		// new Main().solve();
	}

	public StringBuilder solve() {
		InputReader(System.in);
		/*
		 * try { InputReader(new
		 * FileInputStream("C:\\Users\\hardik\\Desktop\\in.txt")); }
		 * catch(FileNotFoundException e) {}
		 */
		pw = new PrintWriter(System.out);
		// ans_sb = new StringBuilder();
		soln();

		pw.close();
		// System.out.println(ans_sb);
		return ans_sb;
	}

	public void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	private int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private String nextToken() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	private int[] nextIntArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		return arr;
	}

	private long[] nextLongArray(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextLong();
		}
		return arr;
	}

	private void pArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private void pArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private char nextChar() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		char c1 = (char) c;
		while (!isSpaceChar(c))
			c = read();
		return c1;
	}

	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
