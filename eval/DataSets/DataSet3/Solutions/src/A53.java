import java.util.*;
import java.io.*;

public class A53 {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    long students=in.nextLong();
    long k=in.nextLong();
    long diplomas=students/(2*k+2);
    long certificates=(students/(2*k+2))*k;
    long winners=diplomas+certificates;
    long notwinners=students-winners;
    System.out.println(diplomas+" "+certificates+" "+notwinners);
  }
}
