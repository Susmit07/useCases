package com.sapient.usecases.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings("rawtypes")
public class ThreadPool {

	private BlockingQueue taskQueue = null; // queue of tasks worker threads picks up tasks  from here.
	private List<PoolThread> threads = new ArrayList<PoolThread>(); // pool of threads.
	private boolean isStopped = false; // is the thread pool started or stopped.

	// Number of threads to have in the thread pool and tasks in the queue
	public ThreadPool(int noOfThreads, int maxNoOfTasks){
		taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

		for(int i=0; i<noOfThreads; i++){
			// add the thread in pool array list.
			threads.add(new PoolThread(taskQueue));
		}
		for(PoolThread thread : threads){
			// start all the threads in constructor of thread pool.
			thread.start();
		}
	}

	//task that needs to be executed..
	@SuppressWarnings("unchecked")
	public synchronized void  execute(Runnable task) throws Exception{
		if(this.isStopped) throw
		new IllegalStateException("ThreadPool is stopped");
		this.taskQueue.offer(task);
	}

	public synchronized void stop(){
		this.isStopped = true;
		for(PoolThread thread : threads){
			if (thread.isAlive()) {
				thread.doStop();
			}
		}
	}

}
