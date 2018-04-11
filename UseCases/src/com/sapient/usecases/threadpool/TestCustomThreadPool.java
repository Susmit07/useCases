package com.sapient.usecases.threadpool;

public class TestCustomThreadPool {
	
	public static void main(String[] args) throws Exception {
		
		ThreadPool threadPool = new ThreadPool(10, 10);
		// Created 5 Tasks and submit to pool
		for (int jobNumber = 1; jobNumber <= 5; jobNumber++) {
			Job task = new Job(jobNumber);
			threadPool.execute(task);
		}
		threadPool.stop();
	}
}
