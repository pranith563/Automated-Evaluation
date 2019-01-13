import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A58 {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long n = sc.nextLong(), k = sc.nextLong();
		long x = (long)( 0.5 * n / (1 + k)), y = x * k;
		out.println(x + " " + y + " " + (n - (x + y)));
		out.flush();
	}

	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		Scanner(InputStream system)
		{
			br = new BufferedReader(new InputStreamReader(system));
		}
		
		String nextLine() throws IOException
		{
			return br.readLine();
		}
		
		String next() throws IOException
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		int nextInt() throws NumberFormatException, IOException
		{
			return Integer.parseInt(next());
		}
		long nextLong() throws NumberFormatException, IOException
		{
			return Long.parseLong(next());
		}
	}
}
