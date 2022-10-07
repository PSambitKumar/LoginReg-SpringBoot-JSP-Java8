package com.sambit.CompetitvePractice.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 27/09/2022 - 5:49 PM
 */
public class Sorting {

//	Sorting Using sort()
	public static int[] sort(int[] arr, int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Bubble Sort
	public static int[] bubbleSort(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Selection Sort
	public static int[] selectionSort(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Insertion Sort
	public static int[] insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Merge Sort
	public static int[] mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

//	Sorting Array Using Quick Sort
	public static int[] quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

//	Sorting Array Using Heap Sort
	public static int[] heapSort(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}

//	Sorting Array Using Counting Sort
	public static int[] countingSort(int[] arr, int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				arr[j++] = i;
				count[i]--;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Radix Sort
	public static int[] radixSort(int[] arr, int n) {
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static int getMax(int[] arr, int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void countSort(int[] arr, int n, int exp) {
		int[] output = new int[n];
		int[] count = new int[10];
		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

//	Sorting Array Using Bucket Sort
	public static int[] bucketSort(int[] arr, int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		max++;
		ArrayList<Integer>[] bucket = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			bucket[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			int bi = (n * arr[i]) / max;
			bucket[bi].add(arr[i]);
		}
		for (int i = 0; i < n; i++) {
			Collections.sort(bucket[i]);
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				arr[index++] = bucket[i].get(j);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Shell Sort
	public static int[] shellSort(int[] arr, int n) {
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Comb Sort
	public static int[] combSort(int[] arr, int n) {
		int gap = n;
		boolean swapped = true;
		while (gap != 1 || swapped == true) {
			gap = getNextGap(gap);
			swapped = false;
			for (int i = 0; i < n - gap; i++) {
				if (arr[i] > arr[i + gap]) {
					int temp = arr[i];
					arr[i] = arr[i + gap];
					arr[i + gap] = temp;
					swapped = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static int getNextGap(int gap) {
		gap = (gap * 10) / 13;
		if (gap < 1) {
			return 1;
		}
		return gap;
	}

//	Sorting Array Using Cycle Sort
	public static int[] cycleSort(int[] arr, int n) {
		for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
			int item = arr[cycleStart];
			int pos = cycleStart;
			for (int i = cycleStart + 1; i < n; i++) {
				if (arr[i] < item) {
					pos++;
				}
			}
			if (pos == cycleStart) {
				continue;
			}
			while (item == arr[pos]) {
				pos++;
			}
			if (pos != cycleStart) {
				int temp = item;
				item = arr[pos];
				arr[pos] = temp;
			}
			while (pos != cycleStart) {
				pos = cycleStart;
				for (int i = cycleStart + 1; i < n; i++) {
					if (arr[i] < item) {
						pos++;
					}
				}
				while (item == arr[pos]) {
					pos++;
				}
				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Pigeonhole Sort
	public static int[] pigeonholeSort(int[] arr, int n) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int range = max - min + 1;
		ArrayList<Integer>[] holes = new ArrayList[range];
		for (int i = 0; i < range; i++) {
			holes[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			holes[arr[i] - min].add(arr[i]);
		}
		int index = 0;
		for (int i = 0; i < range; i++) {
			for (int j = 0; j < holes[i].size(); j++) {
				arr[index++] = holes[i].get(j);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Cocktail Sort
	public static int[] cocktailSort(int[] arr, int n) {
		boolean swapped = true;
		int start = 0;
		int end = n;
		while (swapped == true) {
			swapped = false;
			for (int i = start; i < end - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
			swapped = false;
			end = end - 1;
			for (int i = end - 1; i >= start; i--) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
			start = start + 1;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Gnome Sort
	public static int[] gnomeSort(int[] arr, int n) {
		int index = 0;
		while (index < n) {
			if (index == 0) {
				index++;
			}
			if (arr[index] >= arr[index - 1]) {
				index++;
			} else {
				int temp = 0;
				temp = arr[index];
				arr[index] = arr[index - 1];
				arr[index - 1] = temp;
				index--;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Odd-Even Sort
	public static int[] oddEvenSort(int[] arr, int n) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 1; i <= n - 2; i = i + 2) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}
			for (int i = 0; i <= n - 2; i = i + 2) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Stooge Sort
	public static int[] stoogeSort(int[] arr, int l, int h) {
		if (l >= h) {
			return arr;
		}
		if (arr[l] > arr[h]) {
			int temp = arr[l];
			arr[l] = arr[h];
			arr[h] = temp;
		}
		if (h - l + 1 > 2) {
			int t = (h - l + 1) / 3;
			stoogeSort(arr, l, h - t);
			stoogeSort(arr, l + t, h);
			stoogeSort(arr, l, h - t);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}
}
