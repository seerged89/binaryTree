package sample10;

import java.util.Arrays;

public class Exec {

	public static int BinarySearch(int[] data, int value, int low, int high){

		return -1;
	}


	public static void main(String[] args) {
		// 10. どのように、与えられた配列で二分探索を行いますか？（解答）
		//基本　昇順で、整数の配列が与えられる。
		int[] a = {1,2,3,5,9,10,30,45};
		System.out.println(Arrays.toString(a));

		System.out.println("\n 二分探査の開始");

		int value = 10;//10が配列の中で何番目のindexにあるか、を求める。

		BinarySearch(a, value, 0, a.length-1);

	}

}
