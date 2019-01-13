/**
 * DA-IICT
 * Author : PARTH PATEL
 */
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;


public class A14 
{

	public static int mod = 1000000007;
	static FasterScanner in = new FasterScanner();
	static PrintWriter out = new PrintWriter(System.out);
	static int maxn = (int) (1e5 + 2);
	static ArrayList<Integer>[] adjacencylist = new ArrayList[maxn];
	static boolean[] visited = new boolean[maxn];
	static int[] color = new int[maxn];

	public static void main(String[] args) 
	{
		long n=in.nextLong();
		n*=2;
		Set<Long> set=new HashSet<>();
		for(long i=1;i<=100000;i++)
		{
			set.add(i*(i+1));
		}
		for(long t : set)
		{
			if(set.contains(n-t))
			{
				out.println("YES");
				out.flush();
				return;
			}
		}
		out.println("NO");
		out.close();

	}
	
	public static void dfs(int vertex) 
	{
		visited[vertex] = true;
		for (int i : adjacencylist[vertex])
		{
			if (!visited[i]) 
			{
				dfs(i);
			}
		}
	}
	/////////////////SEGMENT TREE (BUILD-UPDATE-QUERY)/////////////////////////////
	/////////////////UPDATE FOLLOWING METHODS AS PER NEED//////////////////////////
	/*
	public static void buildsegmenttree(int node,int start,int end)
	{
		if(start==end)
		{
			// Leaf node will have a single element
			segmenttree[node]=arr[start];
		}
		else
		{
			int mid=start+(end-start)/2;
			// Recurse on the left child
			buildsegmenttree(2*node, start, mid);
			// Recurse on the right child
			buildsegmenttree(2*node+1, mid+1, end);
			// Internal node will have the sum of both of its children
			segmenttree[node]=segmenttree[2*node]+segmenttree[2*node+1];
		}
	}
	
	public static void updatesegmenttree(int node,int start,int end,int idx,int val)
	{
		if(start==end)
		{
			//Leaf Node
			arr[idx]+=val;
			segmenttree[node]+=val;
		}
		else
		{
			int mid=start+(end-start)/2;
			if(start<=idx && idx<=mid)
			{
				// If idx is in the left child, recurse on the left child
				updatesegmenttree(2*node, start, mid, idx, val);
			}
			else
			{
				// if idx is in the right child, recurse on the right child
				updatesegmenttree(2*node+1, mid+1, end, idx, val);
			}
			// Internal node will have the sum of both of its children
			segmenttree[node]=segmenttree[2*node]+segmenttree[2*node+1];
		}
	}
	
	public static long querysegmenttree(int node,int start,int end,int l,int r)
	{
		if(r<start || end<l)
		{
			// range represented by a node is completely outside the given range
			return 0;
		}
		if(l <= start && end <= r)
	    {
	        // range represented by a node is completely inside the given range
	        return segmenttree[node];
	    }
		// range represented by a node is partially inside and partially outside the given range
		int mid=start+(end-start)/2;
		long leftchild=querysegmenttree(2*node, start, mid, l, r);
		long rightchild=querysegmenttree(2*node+1, mid+1, end, l, r);
		return (leftchild+rightchild);
	}
	*/
	
	public static long pow(long x, long n, long mod) 
	{
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) 
		{
			if ((n & 1) != 0) 
			{
				res = (res * p % mod);
			}
		}
		return res;
	}

	public static long gcd(long n1, long n2) 
	{
		long r;
		while (n2 != 0) 
		{
			r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}

	public static long lcm(long n1, long n2) 
	{
		long answer = (n1 * n2) / (gcd(n1, n2));
		return answer;
	}

	static class FasterScanner 
	{
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;

		public int read() 
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) 
			{
				curChar = 0;
				try 
				{
					snumChars = System.in.read(buf);
				} catch (IOException e) 
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			int res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) 
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) 
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) 
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) 
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}

}
