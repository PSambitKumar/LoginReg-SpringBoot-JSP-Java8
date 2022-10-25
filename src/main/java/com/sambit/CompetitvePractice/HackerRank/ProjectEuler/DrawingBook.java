package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 25/10/2022 - 4:18 PM
 */
public class DrawingBook {
	public static int pageCount(int n, int p) {
		int sheetIndexes = getIndex(n);
		int pageIndex = getIndex(p);

		if(sheetIndexes == pageIndex || pageIndex == 0) {
			return 0;
		} else if (pageIndex <=  sheetIndexes / 2) {
			return pageIndex;
		} else {
			return sheetIndexes - pageIndex;
		}
	}

	private static int getIndex(int page) {
		if(page == 1) {
			return 0;
		} else if (page % 2 == 0) {
			return page / 2;
		} else {
			return (page - 1) / 2;
		}
	}

//	Not Recommended
	public static int pageCount1(int n, int p){
		int count = 0;
		if(p > n/2){
			for(int i = n; i > p; i-=2){
				count++;
			}
		}else{
			for(int i = 1; i < p; i+=2){
				count++;
			}
		}
		return count;
	}


	public static void main(String[] args) {
		System.out.println(pageCount(6, 2));
		System.out.println(pageCount(5, 4));
	}
}
