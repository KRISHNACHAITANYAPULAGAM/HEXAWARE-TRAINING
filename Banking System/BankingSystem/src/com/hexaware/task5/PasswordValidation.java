package com.hexaware.task5;
import java.util.Scanner;

public class PasswordValidation {
	public static void main(String[]args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the paaword: ");
		
		String password=sc.nextLine();
		char[] arr=password.toCharArray();
		boolean isatleast8characters=false;
		boolean hasupper=false;
		boolean hasdigit=false;
		
		for(char c : arr) {
			
			if(arr.length>=8) {
				isatleast8characters=true;
			}
			if(Character.isUpperCase(c)) {
				hasupper=true;
			}
			if(Character.isDigit(c)) {
				hasdigit=true;
			}
		}
		if(hasupper==true & hasdigit==true & isatleast8characters==true) {
			System.out.println("Password accepted");
	}else {
		System.out.println("passwordinvalid");
	}
	
		sc.close();
	}
}
