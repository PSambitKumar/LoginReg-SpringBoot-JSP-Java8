package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 11:45 PM
 */
public class JavaLoopsII {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t=in.nextInt();

	    for(int i=0;i<t;i++){
		    int a = in.nextInt();
		    int b = in.nextInt();
		    int n = in.nextInt();

		    for(int j = 0; j < n; j++){
			    a = a + (int)Math.pow(2,j)*b;
			    System.out.print(a + " ");
		    }
		    System.out.println("");
	    }
	    in.close();
    }
}
