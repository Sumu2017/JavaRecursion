package com.sumu.demo;

/**
 * 汉诺塔
 * 
 * @author sumu
 *
 */
public class HanNota {
	/**
	 * 
	 * @param n
	 *            环的数目
	 * @param origin
	 *            源座
	 * @param assist
	 *            辅助座(中转站)
	 * @param destination
	 *            目的座
	 *            
	 *核心思想:
	 *1、将环n以上的环（n-1个）移动到B
	 *2、将环n从A移动到C
	 *3、将B上的环（n-1个）移动到C
	 */
	public static void hanNota(int n, char origin, char assist, char destination) {
		if (n==1) {
			move(n,origin,destination);
		}else {
			hanNota(n-1, origin, destination, assist);//第一步，将n-1环从A利用C移到B
			move(n, origin, destination);//第二步，将底环从A移到C
			hanNota(n-1, assist, origin, destination);//第三步，将n-1环从B利用A移到C
		}
	}
	
	private static void move(int n, char origin, char destination) {
		// TODO Auto-generated method stub
		System.out.println("将环"+n+"从"+origin+"移到"+destination);
	}

	public static void main(String[] args) {
		hanNota(30, 'A', 'B', 'C');
	}
}
