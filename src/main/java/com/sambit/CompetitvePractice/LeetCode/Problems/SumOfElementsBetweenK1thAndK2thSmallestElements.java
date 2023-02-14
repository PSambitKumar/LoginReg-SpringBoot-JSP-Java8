package com.sambit.CompetitvePractice.LeetCode.Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//QUESTION
/*Sum of elements between k1'th and k2'th smallest elements
	   Given an array A[] of N positive integers and two positive integers K1 and K2. Find the sum of all elements between K1th and K2th smallest elements of the array. It may be assumed that (1 <= k1 < k2 <= n).

	   Example 1:
	   Input:
	   N  = 7
	   A[] = {20, 8, 22, 4, 12, 10, 14}
	   K1 = 3, K2 = 6
	   Output:
	   26
	   Explanation:
	   3rd smallest element is 10
	   6th smallest element is 20
	   Sum of all element between
	   K1 & K2 is 12 + 14 = 26

	   Example 2:
	   Input
	   N = 6
	   A[] = {10, 2, 50, 12, 48, 13}
	   K1= 2, K2 = 6
	   Output:
	   73

	   Your Task:
	   You don't need to read input or print anything. Your task is to complete the function sumBetweenTwoKth() which takes the array A[], its size N and two integers K1 and K2 as inputs and returns the sum of all the elements between K1th and K2th smallest elements.

	   Expected Time Complexity: O(N. log(N))
	   Expected Auxiliary Space: O(N)

	   Constraints:
	   1 ≤ N ≤ 105
	   1 ≤ K1, K2 ≤ 109*/

public class SumOfElementsBetweenK1thAndK2thSmallestElements {
	public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
		for (int i = 0; i < A.length; i++) {
			long l = A[i];
			System.out.println(l);
		}
		Arrays.sort(A);
		System.out.println("After Sort of an Array : ");
		for (int i = 0; i < A.length; i++) {
			long l = A[i];
			System.out.println(l);
		}
		Set<Long> s = new HashSet<Long>();
		System.out.println("HashSet is : " + s);
		long c = 0, sum = 0;

		if(K1>K2)
		{
			long temp = K1;
			K1 = K2;
			K2 = temp;
		}

		for(int i=0;i<N;i++){
			if(s.contains(A[i]) == false){
				s.add(A[i]);
				System.out.println(s);
				c++;
			}
			System.out.println("C : " + c);

			if(c > K1 && c < K2)
				sum+=A[i];

			if(c == K2)
				break;
		}
		return sum;
	}

	public static void main(String[] args) {
		long arr[] = new long[7];
		arr[0] = 20;
		arr[1] = 8;
		arr[2] = 22;
		arr[2] = 4;
		arr[3] = 12;
		arr[4] = 10;
		arr[4] = 14;
		Long sum = sumBetweenTwoKth(arr, 7, 3, 6);
		System.out.println("Sum is : " + sum);
 	}
}
