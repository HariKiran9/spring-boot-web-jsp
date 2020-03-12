package com.hari.thread;

import java.util.concurrent.atomic.LongAdder;

public class TaskLongAdder implements Runnable {
	private final LongAdder lAdder;

	public TaskLongAdder(LongAdder lAdder) {
		this.lAdder = lAdder;
	}

	@Override
	public void run() {
		lAdder.increment();
	}

}
