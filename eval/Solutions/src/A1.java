import java.util.*;
import java.io.*;
import java.math.*;
public class A1
{
    static int n;
    static long arr[];
    static int counter;
    public static void main(String[] args)throws IOException
    {
        PrintWriter out= new PrintWriter(System.out);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int store[]=new int[500000];
        int counter=0;
        for(int i=1;;i++)
        {
            if((i*(i+1))/2>n)
            break;
            store[counter++]=(i*(i+1))/2;
        }
        for(int i = 0 ;i<counter;i++)
        {
            int num=store[i];
            int low=0;
            int high=counter-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(store[mid]==n-num)
                {
                    System.out.println("YES");
                    System.exit(0);
                }
                else if(store[mid]>n-num)
                high=mid-1;
                else
                low=mid+1;
            }
        }
        System.out.println("NO");
        while(true){
            int k;
        }
    }
}
