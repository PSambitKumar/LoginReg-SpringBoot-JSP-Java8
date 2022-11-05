package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 05/11/2022 - 10:44 PM
 */
public class JavaBitSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);

		for (int i = 0; i < m; i++) {
			String op = in.next();
			int x = in.nextInt();
			int y = in.nextInt();

			switch (op) {
				case "AND":
					if (x == 1) {
						b1.and(b2);
					} else {
						b2.and(b1);
					}
					break;
				case "OR":
					if (x == 1) {
						b1.or(b2);
					} else {
						b2.or(b1);
					}
					break;
				case "XOR":
					if (x == 1) {
						b1.xor(b2);
					} else {
						b2.xor(b1);
					}
					break;
				case "FLIP":
					if (x == 1) {
						b1.flip(y);
					} else {
						b2.flip(y);
					}
					break;
				case "SET":
					if (x == 1) {
						b1.set(y);
					} else {
						b2.set(y);
					}
					break;
			}

			System.out.println(b1.cardinality() + " " + b2.cardinality());
		}
	}
}
