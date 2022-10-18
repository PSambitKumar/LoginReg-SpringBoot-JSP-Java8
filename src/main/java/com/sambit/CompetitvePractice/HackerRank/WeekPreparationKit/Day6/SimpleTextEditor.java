package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 8:45 PM
 */
public class SimpleTextEditor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<String> stack = new Stack<>();
		String str = "";
		for (int i = 0; i < T; i++) {
			int op = sc.nextInt();
			switch (op) {
				case 1:
					stack.push(str);
					str += sc.next();
					break;
				case 2:
					stack.push(str);
					int k = sc.nextInt();
					str = str.substring(0, str.length() - k);
					break;
				case 3:
					k = sc.nextInt();
					System.out.println(str.charAt(k - 1));
					break;
				case 4:
					str = stack.pop();
					break;
			}
		}
		sc.close();
	}

	public static void main1(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ops=Integer.parseInt(br.readLine());
		Stack<StringBuilder> st=new Stack<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ops;i++)
		{
			String z[]=br.readLine().split(" ");

			if(z[0].equals("1")){
				st.add(new StringBuilder(sb.toString()));
				sb.append(z[1]);
			}
			if(z[0].equals("2")){
				st.add(new StringBuilder(sb.toString()));
				sb.delete(sb.length()-Integer.parseInt(z[1]),sb.length());
			}
			if(z[0].equals("3")){
				System.out.println(sb.charAt(Integer.parseInt(z[1])-1));
			}
			if(z[0].equals("4")){
				sb=st.pop();
			}
		}
	}
}
