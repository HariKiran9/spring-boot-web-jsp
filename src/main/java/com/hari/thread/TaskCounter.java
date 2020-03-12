package com.hari.thread;

import java.util.concurrent.atomic.AtomicLong;

public class TaskCounter implements Runnable {
	private AtomicLong counter;

	public TaskCounter(AtomicLong counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		long count = counter.incrementAndGet();
		System.out.println("Count : " + count);
	}

}
