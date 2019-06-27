package com.cg;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {

	public static void main(String[] args) {
		Runnable r=new MyRunnable();
		Executor executor=Executors.newSingleThreadExecutor();
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
	}

}
