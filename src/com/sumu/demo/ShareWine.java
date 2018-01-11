package com.sumu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 泊松分酒(穷举法+递归)
 * 
 * @author YaoMingliang
 * @date 2018年1月11日 下午9:48:46 
 * 有3个容器，容量分别为12升，8升，5升。
 * 其中12升中装满酒，另外两个空着。要求你只用3个容器操作，最后使得某个容器中正好有6升酒。
 */
public class ShareWine {
	// 12升的容器A
	private final static int CUP_A = 12;
	// 8升的容器B
	private final static int CUP_B = 8;
	// 5升的容器C
	private final static int CUP_C = 5;
	// 需要查找的6升酒
	private final static int NEED_FIND = 13;
	// 记录倒酒后每个容器里面的剩余酒
	private List<List<Integer>> record = new ArrayList<>();

	/**
	 * 制定倒酒的规则： 1、从curCupA-->curCupB-->curCupC-->curCupA 按这种顺序循环倒酒
	 * 2、curCupB为空时，curCupA才能向curCupB倒酒
	 * 3、curCupC不满时，curCupB才能向curCupC倒酒
	 * 4、curCupC满时，curCupC才能向curCupA倒酒
	 * 
	 * @param curCupA
	 *            12升容器当前盛放了多少升酒
	 * @param curCupB
	 *            8升容器当前盛放了多少升酒
	 * @param curCupC
	 *            5升容器当前盛放了多少升酒
	 */
	public void shareWine(int curCupA, int curCupB, int curCupC) {
		System.out.println("A:" + curCupA + " B:" + curCupB + " C:" + curCupC);
		if (curCupA == NEED_FIND || curCupB == NEED_FIND || curCupC == NEED_FIND) {
			System.out.println("find it");
			return;
		}
		boolean curExist = curExist(curCupA, curCupB, curCupC);
		if (curExist) {
			// 该情况不可能，停止倒酒
			System.out.println("The situation is impossible");
			return;
		}

		if (curCupB == 0) {
			// B容器为空时，从A容器倒酒到B容器
			if (curCupA <= CUP_B) {
				// curCupA里面的酒不够倒满curCupB
				shareWine(0, curCupA, curCupC);
			} else {
				shareWine(curCupA - CUP_B, CUP_B, curCupC);
			}
		} else if (curCupC < CUP_C) {
			// C容器不满，从B容器倒酒到C容器
			if (curCupB + curCupC <= CUP_C) {
				// curCupB里面的酒不够倒满curCupC
				shareWine(curCupA, 0, curCupB + curCupC);
			} else {
				shareWine(curCupA, curCupB - (CUP_C - curCupC), CUP_C);
			}
		} else if (curCupC == CUP_C) {
			// C容器满的，从C容器倒酒到A容器
			if (curCupC + curCupA <= CUP_A) {
				// curCupC里面的酒不够倒满curCupA
				shareWine(curCupA + curCupC, curCupB, 0);
			} else {
				shareWine(CUP_A, curCupB, curCupC - (CUP_A - curCupA));
			}
		}
	}

	/**
	 * 判断当前容器里面剩余的酒是否记录过,如果记录过说明重复了，说明不可能实现，或者达到1000次也认为不可能实现
	 * 
	 * @param curCupA
	 * @param curCupB
	 * @param curCupC
	 * @return
	 */
	private boolean curExist(int curCupA, int curCupB, int curCupC) {
		if (record.size() >= 1000) {
			// 记录次数达到1000次，停止倒酒
			return true;
		}
		for (int i = 0; i < record.size(); i++) {
			List<Integer> r = record.get(i);
			if (r.get(0) == curCupA && r.get(1) == curCupB && r.get(2) == curCupC) {
				// 遍历倒酒记录，如果存在同样的情况，停止倒酒
				return true;
			}
		}
		// 遍历倒酒记录后，不存在记录，则添加新的记录
		List<Integer> r = new ArrayList<>();
		r.add(curCupA);
		r.add(curCupB);
		r.add(curCupC);
		record.add(r);
		return false;
	}

	public static void main(String[] args) {
		ShareWine shareWine = new ShareWine();
		shareWine.shareWine(12, 0, 0);
	}
}
