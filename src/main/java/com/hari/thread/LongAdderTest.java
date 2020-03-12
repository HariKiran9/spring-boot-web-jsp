package com.hari.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

	public static void main(String[] args) {
		LongAdder lAdder = new LongAdder();
		ExecutorService eService = Executors.newFixedThreadPool(16);
		for (int i = 0; i < 100; i++) {
			eService.submit(new TaskLongAdder(lAdder));
		} // for

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		System.out.println(" Counter : 	" + lAdder.sum());

	}

}
