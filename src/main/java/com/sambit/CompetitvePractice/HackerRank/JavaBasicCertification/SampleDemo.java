package com.sambit.CompetitvePractice.HackerRank.JavaBasicCertification;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 10:30 PM
 */

class SampleDemo implements Runnable {
	private Thread t;
	private String threadName;

	SampleDemo(String name) {
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
			SampleDemo sampleDemo = new SampleDemo("A");
			sampleDemo.start();

			SampleDemo sampleDemo1 = new SampleDemo("B");
			sampleDemo1.start();
		}
	}

}
