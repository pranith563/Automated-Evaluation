import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class A3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int index = 1, sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (sum + index <= n) {
            sum += index;
            index++;
            list.add(sum);
        }
        int size = list.size();
        index = 0;
        while (index < size) {
            if (Collections.binarySearch(list, n - list.get(index)) >= 0) {
                bw.write("YES\n");
                bw.flush();
                return;
            }
            index++;
        }
        bw.write("NO\n");
        bw.flush();
    }
}
