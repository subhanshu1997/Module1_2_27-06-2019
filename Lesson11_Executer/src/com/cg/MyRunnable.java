package com.cg;
public class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("Happy Bithday Tom"+Thread.currentThread().getName());	
	}

}
