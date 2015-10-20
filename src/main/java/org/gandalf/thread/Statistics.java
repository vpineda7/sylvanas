package org.gandalf.thread;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Statistics {
	
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<Map<String, Integer>> fs = exec.submit(new StatisticsWord("a b c d a "));
		
		try {
			System.out.println(fs.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			exec.shutdown();
		}
	}
}
