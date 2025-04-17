package com.hexaware.task4;

import java.util.HashMap;
import java.util.Scanner;



public class Loopin_Array_DataValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int accountnum=sc.nextInt();
		sc.nextLine();
		HashMap<String,Integer> map=new HashMap<>();
		for(int i=0;i<accountnum;i++) {
			System.out.println("enter the Account Number: ");
			String acc=sc.nextLine();
			System.out.println("enter the balance");
			int balance=sc.nextInt();
			sc.nextLine();
			map.put(acc, balance);
		}

while(true) {
	System.out.println("Enter the Account number to check balance: ");
	String temp=sc.nextLine();
	if(map.containsKey(temp)) {
		System.out.println("The balance is "+map.get(temp));
		sc.close();
		return;
	}else {
		System.out.println("try again");
	}
	
}

	}

}
