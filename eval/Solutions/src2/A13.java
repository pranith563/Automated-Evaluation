//rextester.com:1.8.0_111--codeforces.com:1.8.0_112
import java.util.Scanner;
public class A13{
    public static void main(String args[]){
        Scanner z=new Scanner(System.in);int a=z.nextInt()*2;boolean b=false;
        for(int i=1;i<(int)Math.sqrt(a);i++){
            int c=a-i*i-i;int d=(int)Math.sqrt(c);
            if(d*(d+1)==c)b=true;
        }
        System.out.print(b?"YES":"NO");
    }
}
