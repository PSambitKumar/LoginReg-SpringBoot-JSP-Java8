package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day7;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 10:12 AM
 */

abstract class Node1 implements Comparable<Node1> {
	public  int frequency; // the frequency of this tree
	public  char data;
	public  Node1 left, right;
	public Node1(int freq) {
		frequency = freq;
	}

	public int compareTo(Node1 tree) {
		return frequency - tree.frequency;
	}
}

class HuffmanLeaf extends Node1 {


	public HuffmanLeaf(int freq, char val) {
		super(freq);
		data = val;
	}
}

class HuffmanNode1 extends Node1 {

	public HuffmanNode1(Node1 l, Node1 r) {
		super(l.frequency + r.frequency);
		left = l;
		right = r;
	}

}
public class HuffmanDecoding {

// input is an array of frequencies, indexed by character code
//	Working Perfectly All Test Cases are Passed
	void decode(String s, Node1 root){
		Node1 temp = root;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
			if (temp.left == null && temp.right == null) {
				System.out.print(temp.data);
				temp = root;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String test = scan.next();
		scan.close();
		Node1 root = new HuffmanNode1(new HuffmanLeaf(3, 'A'), new HuffmanNode1(new HuffmanLeaf(1, 'B'), new HuffmanLeaf(1, 'C')));
		new HuffmanDecoding().decode(test, root);
	}


}
