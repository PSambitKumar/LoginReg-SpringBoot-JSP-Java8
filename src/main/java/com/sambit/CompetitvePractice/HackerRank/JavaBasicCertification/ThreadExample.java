package com.sambit.CompetitvePractice.HackerRank.JavaBasicCertification;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 10:30 PM
 */

class ThreadExample implements Runnable {
	private Thread t;
	private String threadName;

	ThreadExample(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		while (true){
			System.out.println(threadName);
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static class testThread{
		public static void main(String[] args) {
			ThreadExample threadExample1 = new ThreadExample("A");
			threadExample1.start();

			ThreadExample threadExample2 = new ThreadExample("B");
			threadExample2.start();
		}
	}

}
