package com.sumu.demo;
/**
 * 欧几里德算法
 * @author sumu
 *
 */
public class Gcd {
	/**
	 * 欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数
	 * 定理：两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m,int n) {
		if (m%n==0) {
			return n;
		}else {
			return gcd(m, m%n);
		}
		
	}
	
	public static void main(String[] args) {
		int gcd = gcd(44, 12);
		System.out.println("最大公约数为:"+gcd);
	}
}
