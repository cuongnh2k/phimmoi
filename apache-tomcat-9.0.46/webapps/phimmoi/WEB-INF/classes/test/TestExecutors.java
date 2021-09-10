package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestExecutors {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		Runnable runnable = () -> {
//			try {
//				String name = Thread.currentThread().getName();
//				System.out.println("Foo " + name);
//				TimeUnit.SECONDS.sleep(1);
//				System.out.println("Bar " + name);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		};
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			executor.execute(runnable);
//		}
		Future<Integer> future = executor.submit(task);
		System.out.println(future.get());
		executor.shutdown();
	}
	
}
