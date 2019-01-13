import java.io.*;
import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        
        try{
            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            /* Enter your code here. Print output to STDOUT. */
            int n=A.length();
            int p1=0,p2=n-1;
            while (p1<p2){
                if (A.charAt(p1)!=A.charAt(p2)){
                    System.out.println("No");
                    return;
                }
                p1+=1;
                p2-=1;
            }
            System.out.println("Yes");
            return;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
