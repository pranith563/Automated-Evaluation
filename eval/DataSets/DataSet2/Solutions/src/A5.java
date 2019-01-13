import java.io.*;
import java.util.*;

public class A5{
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    

    public void solve(){
        TreeSet<Integer> set = new TreeSet<Integer>();
        int i=1, k=1;

        while(i<=1000000000){
            set.add(i);
            k+=1;
            i=i+k;
        }
        int num=ni();
        for(Integer elem : set){
            if(set.contains(num-elem)){
                out.println("YES");
                return;
            }
        }    
        out.println("NO");
    }
    

    void run(){
        is = new DataInputStream(System.in);
        out = new PrintWriter(System.out);
        int t=1;while(t-->0)solve();
        out.flush();
    }
    public static void main(String[] args)throws Exception{new A5().run();}
    //Fast I/O code is copied from uwi code.
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
    private int readByte(){
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }
    private String ns(){
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    private char[] ns(int n){
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    private char[][] nm(int n, int m){
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    private int[] na(int n){
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    private int ni(){
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    private long nl(){
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    static  int i(long x){return (int)Math.round(x);}
    static class Pair implements Comparable<Pair>{
        long fs,sc;
        Pair(long a,long b){
            fs=a;sc=b;
        }
        public int compareTo(Pair p){
            if(this.fs>p.fs)return 1;
            else if(this.fs<p.fs)return -1;
            else{
                return i(this.sc-p.sc);
            }
            //return i(this.sc-p.sc);
        }
        public String toString(){
            return "("+fs+","+sc+")";
        }    
    }
    
}
