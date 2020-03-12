/**
 * 
 */
package com.hari.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author bc887d
 *
 */
public class Task implements Runnable {

	private CyclicBarrier cBarrier;
//	private int i = 0;

	public Task(CyclicBarrier cBarrier) {
		this.cBarrier = cBarrier;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			int i = cBarrier.await();
			System.out.println(" i : " + i);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} // catch
//		while (true) {
//			try {
//				cBarrier.await();
//			} catch (InterruptedException | BrokenBarrierException e) {
//				e.printStackTrace();
//			} // catch
//		} // while
	}

}
