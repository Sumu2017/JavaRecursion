package com.sumu.demo;

/**
 * ��ŵ��
 * 
 * @author sumu
 *
 */
public class HanNota {
	/**
	 * 
	 * @param n
	 *            ������Ŀ
	 * @param origin
	 *            Դ��
	 * @param assist
	 *            ������(��תվ)
	 * @param destination
	 *            Ŀ����
	 *            
	 *����˼��:
	 *1������n���ϵĻ���n-1�����ƶ���B
	 *2������n��A�ƶ���C
	 *3����B�ϵĻ���n-1�����ƶ���C
	 */
	public static void hanNota(int n, char origin, char assist, char destination) {
		if (n==1) {
			move(n,origin,destination);
		}else {
			hanNota(n-1, origin, destination, assist);//��һ������n-1����A����C�Ƶ�B
			move(n, origin, destination);//�ڶ��������׻���A�Ƶ�C
			hanNota(n-1, assist, origin, destination);//����������n-1����B����A�Ƶ�C
		}
	}
	
	private static void move(int n, char origin, char destination) {
		// TODO Auto-generated method stub
		System.out.println("����"+n+"��"+origin+"�Ƶ�"+destination);
	}

	public static void main(String[] args) {
		hanNota(30, 'A', 'B', 'C');
	}
}
