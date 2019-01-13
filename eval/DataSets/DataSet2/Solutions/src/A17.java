import java.util.*;
public class A17 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Vector<Long> v = new Vector<Long>();
        
        for (int i = 1;; i++) {
            long m = i * (i + 1) / 2;
            if (m >= n) {
                break;
            } else {
                v.add(m);
            }
        }
        for (int i = 0; i < v.size(); i++) {
            long complement = n - v.get(i);       
            long r = Collections.binarySearch(v, complement);
            if (r >= 0) {
                System.out.println("YES");           
                System.exit(0);
            }          
        }
        System.out.println("NO");
    }

}
