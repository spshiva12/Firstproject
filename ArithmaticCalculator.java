package com.shivaprasad.FirstProject;

import java.util.*;

public class ArithmaticCalculator {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		float a = sc.nextFloat();
		float b= sc.nextFloat();
		
		System.out.println("enter any operator (+, -, * , /, %)");
		
		char op = sc.next().charAt(0);
		
		double o = 0;
		
		switch(op) {
		
		case '+' :
			o = a + b;
			break;
			
		case '-' :
			o = a - b;
			break;
			
		case '*' :
			o = a * b;
			break;
			
		case '/' :
			o = a / b;
			break;
			
		case '%' :
			o = a % b;
			break;
			
		default :
			
			System.out.println(" you enter wrong input ");
			break;
		}
		 System.out.println("The final result:");
		 
		 System.out.println();
		 
		 System.out.println(a + " " + op + " " + b + " = " + o);
		
		
	}

}
