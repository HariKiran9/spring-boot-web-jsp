package com.hari.thread;

import java.util.concurrent.atomic.LongAccumulator;

public class TaskLongAccumulator implements Runnable {

	private LongAccumulator lAccumulator;

	public TaskLongAccumulator(LongAccumulator lAccumulator) {
		this.lAccumulator = lAccumulator;
	}

	@Override
	public void run() {
		lAccumulator.accumulate(1);

	}

}
