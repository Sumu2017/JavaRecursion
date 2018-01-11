package com.sumu.demo;

/**
 * 二分法查找
 * 
 * @author sumu
 *
 */
public class BinarySearch {
	/**
	 * 二分法查找，递归
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @param value
	 * @return
	 */
	public static int binarysearch(int[] array, int left, int right, int value) {
		if (left > right) {
			System.out.println(value + " 不存在");
			return -1;
		}
		int middle = (left + right) / 2;
		if (array[middle] == value) {
			System.out.println(value + " 查找到了,位置下标为:" + middle);
			return middle;
		}
		if (array[middle] > value) {
			// 如果中间值大于查找的数，则说明value还在middle的左边
			binarysearch(array, left, middle - 1, value);
		} else {
			binarysearch(array, middle + 1, right, value);
		}	
		return -1;
	}

	/**
	 * 二分法查找，非递归
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public static int directBinarySearch(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] > value) {
				// 如果中间值大于查找的数，则说明value还在middle的左边
				right = middle - 1;
			} else if(array[middle] < value){
				left = middle + 1;
			}else {
				System.out.println(value + " 查找到了,位置下标为:" + middle);
				return middle;
			}
		}
		System.out.println(value + " 不存在");
		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 7, 9, 11, 14, 16, 19, 20, 35 };
		// BinarySearch.directBinarySearch(array, 7);
		BinarySearch.binarysearch(array, 0, array.length - 1, 5);
	}
}
