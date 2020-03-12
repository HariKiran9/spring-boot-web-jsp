package com.hari.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class AccumulatorTest {

	public static void main(String[] args) {
		LongAccumulator lAccumalter = new LongAccumulator((x, y) -> x + y, 0);
		ExecutorService eService = Executors.newFixedThreadPool(16);
		for (int i = 0; i < 100; i++) {
			eService.submit(new TaskLongAccumulator(lAccumalter));
		} // for

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		System.out.println(" Counter : 	" + lAccumalter.get());
		
		eService.shutdown();

	}

}
