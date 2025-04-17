package com.hexaware.task3;
import java.util.Scanner;
public class LoopStructures {
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the initial balance: ");
		int balance=sc.nextInt();
		sc.nextLine();
		System.out.println("enter the rate of intrest: ");
		float Rate=sc.nextFloat();
		System.out.println("enter the time of duration: ");
		int duration=sc.nextInt();
		
		float amount=(float) (balance*Math.pow((1+Rate/100),duration));
		System.out.println("final amount is: "+amount);
		sc.close();
	}

}
