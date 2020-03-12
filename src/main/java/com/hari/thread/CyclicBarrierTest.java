package com.hari.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(4);
		CyclicBarrier cBarrier = new CyclicBarrier(3);
		eService.submit(new Task(cBarrier));
		eService.submit(new Task(cBarrier));
		eService.submit(new Task(cBarrier));

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // catch
		
		System.out.println(" CyclicBarrierTest Done !!!");
	}

}
