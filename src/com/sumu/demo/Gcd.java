package com.sumu.demo;
/**
 * ŷ������㷨
 * @author sumu
 *
 */
public class Gcd {
	/**
	 * ŷ������㷨�ֳ�շת���������ָ���ڼ�������������a��b�����Լ��
	 * �����������������Լ���������н�С���Ǹ���������������������Լ��
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
		System.out.println("���Լ��Ϊ:"+gcd);
	}
}
