package com.sapient.usecases;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//[3] Implement producer/consumer problem using custom blocking queue.

public class BlockingQueueProducerConsumer {

	public static void main(String[]args){
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
		Thread t1 = new Thread(new Producers(bq));
		Thread t2 = new Thread(new Consumers(bq));
		t1.start();
		t2.start();
	}
}

class Producers implements Runnable{

	BlockingQueue<Integer> bq = null;
	private int i =0;

	public Producers(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		while(true){
			produce(i++);
		}
	}

	public void produce(int i) {
		System.out.println("Producer Thread produced element "+i);
		try {
			// using put in place of add, because if the queue is full it will wait for the queue to get empty then it starts producing again
			bq.put(i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class Consumers implements Runnable{

	BlockingQueue<Integer> bq = null;

	public Consumers(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		while(true){
			consume();
		}
	}

	public void consume() {
		try {
			System.out.println("Consumed the object succesfully "+bq.take());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

