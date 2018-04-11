package com.sapient.usecases.threadpool;

import java.util.concurrent.BlockingQueue;

@SuppressWarnings("rawtypes")
public class PoolThread extends Thread {
	
	private BlockingQueue taskQueue = null;
    private boolean isStopped = false;
    
	public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
    	// if not stopped then pick up task from queue and complete the task
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
