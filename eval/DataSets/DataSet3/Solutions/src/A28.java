//package Div2A;

import java.util.Scanner;

public class A28 {
	public static void main(String[] args) {
		Scanner br=new Scanner(System.in);
	
		long n=br.nextLong();
		long k=br.nextLong();
		

		long notWinner = (n-n/2/(k+1)-n/2/(k+1)*k);
		long diploma = (n/2)/(k+1);
		long certi = n/2/(k+1)*k;
		
		System.out.println(diploma+" "+certi+" "+notWinner);

	}
}
