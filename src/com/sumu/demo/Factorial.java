package com.sumu.demo;
/**
 * �׳��㷨
 * @author sumu
 *
 */
public class Factorial {
	public static int factorial(int n) {
		if (n==1) {
			return n;
		}else {
			return n*factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		int factorial = factorial(5);
		System.out.println("�׳˽��:"+factorial);
	}
}
