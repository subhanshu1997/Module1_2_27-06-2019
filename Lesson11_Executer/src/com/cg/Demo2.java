package com.cg;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {

	public static void main(String[] args) {
		//ExecutorService executor=Executors.newSingleThreadExecutor();
		ExecutorService executor=Executors.newFixedThreadPool(8);
		Runnable task=()->System.out.println("th1 service pattern Run method executed by "+Thread.currentThread().getName());
		Runnable task1=()->System.out.println("th2 service pattern Run method executed by  "+Thread.currentThread().getName());
		Runnable task2=()->System.out.println("th3 service pattern Run method executed by  "+Thread.currentThread().getName());
		executor.execute(task);
		executor.execute(task1);
		executor.execute(task2);
		executor.shutdown();
	}

}
