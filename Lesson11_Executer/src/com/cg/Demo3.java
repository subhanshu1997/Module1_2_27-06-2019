package com.cg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo3 {

	public static void main(String[] args) {
	shareMarket sm=new shareMarket();
	ExecutorService executor=Executors.newFixedThreadPool(10);
	List<Future<Double>> reslist=new ArrayList<>();
	for(int i=1;i<5;i++) {
		Future<Double> f=executor.submit(sm);
		//automatic thread created,started and calling method call()
		//call() method returns double price stored as Future<Double>
		reslist.add(f);
	}
	try {
		executor.awaitTermination(5,TimeUnit.SECONDS);
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
	executor.shutdown();
	double price=0.0;
	for(Future<Double> f:reslist) {
		try {
			price=f.get();
		}catch (InterruptedException |ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Price"+price);
	}
	}
}
