package com.cg;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo1 {

	public static void main(String[] args) {
		Executor executor=Executors.newSingleThreadExecutor();
		Runnable r=()->System.out.println("Run method executed by "+Thread.currentThread().getName());
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
	}

}
