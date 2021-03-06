package com.sapient.usecases;

import java.util.ArrayList;
import java.util.List;

//[3.]Implement producer/consumer problem using wait and notify

public class ProducerConsumerusingWaiNotify {

	public static void main(String[]args){
		List<Integer> sharedList = new ArrayList<>();
		Thread t1 = new Thread(new Producer(sharedList));
		Thread t2 = new Thread(new Consumer(sharedList));
		t1.start();
		t2.start();
	}
}


class Producer implements Runnable{

	List<Integer> sharedList = null;
	final int MAX_SIZE = 5;
	private int i =0;

	public Producer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while(true){
			produce(i++);
		}
	}

	public void produce(int i) {
		synchronized (sharedList) {
			while(sharedList.size()==MAX_SIZE){
				try {
					System.out.println("Shared list is full and waiting for consume!!");
					sharedList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		synchronized (sharedList) {
			System.out.println("Producer produce the element: "+i);
			sharedList.add(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				sharedList.notify();
			}
		}
	}
}


class Consumer implements Runnable{

	List<Integer> sharedList = null;

	public Consumer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while(true){
			consume();
		}
	}

	public void consume() {

		synchronized (sharedList) {
			while(sharedList.isEmpty()){
				try {
					System.out.println("Shared list is empty.. Waiting for the producer to produce object!!");
					sharedList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedList) {
			try {
				Thread.sleep(1000);
				System.out.println("Consumed the object succesfully "+sharedList.remove(0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				sharedList.notify();
			}
		}
	}
}
