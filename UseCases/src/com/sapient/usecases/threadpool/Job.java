package com.sapient.usecases.threadpool;

public class Job implements Runnable{
	private int number;

	public Job(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("Start executing of task number :" + number);
		try {
			// Simulating processing time
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End executing of task number :" + number);
	}
}
