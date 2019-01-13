import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A18 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 2*Integer.parseInt(in.readLine());
		int y = (int) Math.floor(Math.sqrt(n))+1;
		
		int c = 0;
		while((y-c) > 0) {
			int k = n - (y-c)*(y-c+1);
			int j = (int) Math.floor(Math.sqrt(k)) + 1;
			int h = 0;
			while((j - h) > 0) {
				int u = k - (j-h)*(j-h+1);
				if(u == 0) {
					System.out.println("YES");
					return;
				} else if(u > 0) {
					break;
				}
				h++;
			}
			c++;
		}
		System.out.println("NO");
	}
}
