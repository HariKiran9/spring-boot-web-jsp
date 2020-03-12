package com.hari.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

	public static void main(String[] args) {
		AtomicLong aLong = new AtomicLong(0);
		ExecutorService eService = Executors.newFixedThreadPool(16);
		for (int i = 0; i < 100; i++) {
			eService.submit(new TaskCounter(aLong));
		} // for

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		System.out.println(" Counter : 	" + aLong.get());

	}

}
