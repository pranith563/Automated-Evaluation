import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            boolean valid = true;
        
            for(int i = 0; i < (A.length() / 2); i++) {
                if(A.charAt(i) != A.charAt((A.length() - 1) - i)) {
                    valid = false;
                    break;
                } // end if
            } // end for(i)
        
            if(valid) System.out.println("Yes");
            else System.out.println("No");
        } // end main
        catch(Exception e){
            e.printStackTrace();
        }
    }

} // end class
