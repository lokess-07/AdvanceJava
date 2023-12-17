package in.co.rays.practice;

import java.util.Scanner;

public class Calculator1 {
	public static void main(String[] args) {
		int balance = 5000;
		int widhtrow;
		int deposit;
		
		Scanner sc = new Scanner(System.in);
		int id = 100289;
		int pass=1122;
		System.out.println("Enter your Id  ");
		int id2 = sc.nextInt();
		System.out.println("Enter your Password  ");
		int pass2 = sc.nextInt();
		
		if(id==id2&&pass==pass2) {
		System.out.println("Welcome to Atm ...!");
		System.out.println();
		System.out.println("Enter 1 for Widthrow Money ...!");
		System.out.println("Enter 2 for Deposit Money ...!");
		System.out.println("Enter 3 for Check balance ...!");
		System.out.println("Enter 4 for Exit your Atm Account");
		System.out.println("Enter your Choice");
		int Choice=sc.nextInt();
		
		switch(Choice){
		case:1
		
		break;
		}S
		}
		else {
			System.out.println("invalid Id & password");
		}
	}
}
