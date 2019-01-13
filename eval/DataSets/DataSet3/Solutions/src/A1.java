import java.util.*;
import java.io.*;
import java.text.*;
public class A1{
    static final long mod = (long)1e9+7;
    static long IINF = (long)1e18+1;
    static int MAX = (int)1e6+1, B = 10;
    static FastReader in;
    
    public static void main(String[] args) throws Exception{
        in = new FastReader();
        long n = nl(), k = nl();
        long win = n/2;
        long a = win/(k+1);
        win = a*k;
        pn(a+" " + win+" " + (n-win-a));
    }
    
    static int[] ia(int n){
        int[] out = new int[n];
        for(int i = 0; i< n; i++)out[i] = ni();
        return out;
    }
    
    static long[] la(int n){
        long[] out = new long[n];
        for(int i = 0; i< n; i++)out[i] = nl();
        return out;
    }
    
    static long gcd(long a, long b){
        return (b==0)?a:gcd(b,a%b);
    }
    
    static void p(Object o){
        System.out.print(o);
    }
    
    static void pn(Object o){
        System.out.println(o);
    }
    
    static String n(){
        return in.next();
    }
    
    static String nln(){
        return in.nextLine();
    }
    
    static int ni(){
        return Integer.parseInt(in.next());
    }
    
    static long nl(){
            return Long.parseLong(in.next());
    }
    
    static double nd(){
        return Double.parseDouble(in.next());
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
