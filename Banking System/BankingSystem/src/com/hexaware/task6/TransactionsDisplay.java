package com.hexaware.task6;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionsDisplay {
	
	public static void main(String[]args) {
		int balance = 0;
		ArrayList<String> transactions=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("1.Deposit\n2.Withdraw\n3.show transactions\n4.Exit");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Amount to deposit: ");
			int dep=sc.nextInt();
			sc.nextLine();
			balance+=dep;
			transactions.add("Deposit: "+dep);
			break;
			
		case 2:
			System.out.println("amount to withdraw: ");
			int withdraw=sc.nextInt();
			sc.nextLine();
			if(withdraw>balance) {
				System.out.println("Insyfficient Balance");
			}
			else{
				balance-=withdraw;
				transactions.add("withdraw: "+withdraw);
			}
			break;
		case 3:
			System.out.println("all the Transactions are: ");
			for(String s:transactions) {
				System.out.println(s);
			}
			break;
		case 4:
			System.out.println("Total Balance: "+balance);
			System.out.println("exiting....");
			return;
		}
		sc.close();
	}
		
		}

}
