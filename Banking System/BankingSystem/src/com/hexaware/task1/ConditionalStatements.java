package com.hexaware.task1;
import java.util.Scanner;
public class ConditionalStatements {

	public static void main(String[]args) {
		
		int creditscore;
		int income;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the creditscore: ");
		creditscore=sc.nextInt();
		sc.nextLine();
		System.out.println("enter the income: ");
		income=sc.nextInt();
		sc.nextLine();
//		
//		if(creditscore<=700) {
//			System.out.println("you are not eligible for this loan");
//		}else if(income<=50000) {
//			System.out.println("you are not eligible for this loan");
//		}
		if(creditscore<=700 || income<=50000) {
			System.out.println("you are not eligible for this loan");
		}
		else {
			System.out.println("you are eligible");
		}
		sc.close();
	}
}
