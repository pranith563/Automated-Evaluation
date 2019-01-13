import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        
        try{
            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            
            boolean flag = true;
            for(int i=0;i<A.length()/2;++i)
            {
                if(A.charAt(i)==A.charAt(A.length()-i-1))
                    continue;
                else
                {
                    System.out.println("No");
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("Yes");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
