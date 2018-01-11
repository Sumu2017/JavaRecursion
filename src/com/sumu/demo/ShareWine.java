package com.sumu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ɷ־�(��ٷ�+�ݹ�)
 * 
 * @author YaoMingliang
 * @date 2018��1��11�� ����9:48:46 
 * ��3�������������ֱ�Ϊ12����8����5����
 * ����12����װ���ƣ������������š�Ҫ����ֻ��3���������������ʹ��ĳ��������������6���ơ�
 */
public class ShareWine {
	// 12��������A
	private final static int CUP_A = 12;
	// 8��������B
	private final static int CUP_B = 8;
	// 5��������C
	private final static int CUP_C = 5;
	// ��Ҫ���ҵ�6����
	private final static int NEED_FIND = 13;
	// ��¼���ƺ�ÿ�����������ʣ���
	private List<List<Integer>> record = new ArrayList<>();

	/**
	 * �ƶ����ƵĹ��� 1����curCupA-->curCupB-->curCupC-->curCupA ������˳��ѭ������
	 * 2��curCupBΪ��ʱ��curCupA������curCupB����
	 * 3��curCupC����ʱ��curCupB������curCupC����
	 * 4��curCupC��ʱ��curCupC������curCupA����
	 * 
	 * @param curCupA
	 *            12��������ǰʢ���˶�������
	 * @param curCupB
	 *            8��������ǰʢ���˶�������
	 * @param curCupC
	 *            5��������ǰʢ���˶�������
	 */
	public void shareWine(int curCupA, int curCupB, int curCupC) {
		System.out.println("A:" + curCupA + " B:" + curCupB + " C:" + curCupC);
		if (curCupA == NEED_FIND || curCupB == NEED_FIND || curCupC == NEED_FIND) {
			System.out.println("find it");
			return;
		}
		boolean curExist = curExist(curCupA, curCupB, curCupC);
		if (curExist) {
			// ����������ܣ�ֹͣ����
			System.out.println("The situation is impossible");
			return;
		}

		if (curCupB == 0) {
			// B����Ϊ��ʱ����A�������Ƶ�B����
			if (curCupA <= CUP_B) {
				// curCupA����ľƲ�������curCupB
				shareWine(0, curCupA, curCupC);
			} else {
				shareWine(curCupA - CUP_B, CUP_B, curCupC);
			}
		} else if (curCupC < CUP_C) {
			// C������������B�������Ƶ�C����
			if (curCupB + curCupC <= CUP_C) {
				// curCupB����ľƲ�������curCupC
				shareWine(curCupA, 0, curCupB + curCupC);
			} else {
				shareWine(curCupA, curCupB - (CUP_C - curCupC), CUP_C);
			}
		} else if (curCupC == CUP_C) {
			// C�������ģ���C�������Ƶ�A����
			if (curCupC + curCupA <= CUP_A) {
				// curCupC����ľƲ�������curCupA
				shareWine(curCupA + curCupC, curCupB, 0);
			} else {
				shareWine(CUP_A, curCupB, curCupC - (CUP_A - curCupA));
			}
		}
	}

	/**
	 * �жϵ�ǰ��������ʣ��ľ��Ƿ��¼��,�����¼��˵���ظ��ˣ�˵��������ʵ�֣����ߴﵽ1000��Ҳ��Ϊ������ʵ��
	 * 
	 * @param curCupA
	 * @param curCupB
	 * @param curCupC
	 * @return
	 */
	private boolean curExist(int curCupA, int curCupB, int curCupC) {
		if (record.size() >= 1000) {
			// ��¼�����ﵽ1000�Σ�ֹͣ����
			return true;
		}
		for (int i = 0; i < record.size(); i++) {
			List<Integer> r = record.get(i);
			if (r.get(0) == curCupA && r.get(1) == curCupB && r.get(2) == curCupC) {
				// �������Ƽ�¼���������ͬ���������ֹͣ����
				return true;
			}
		}
		// �������Ƽ�¼�󣬲����ڼ�¼��������µļ�¼
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
