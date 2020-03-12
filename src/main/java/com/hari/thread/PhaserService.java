package com.hari.thread;

import java.util.concurrent.Phaser;

public class PhaserService implements Runnable {

	private Phaser phaser;

	public PhaserService(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		int i = phaser.arrive();
		System.out.println(" i : " + i);

	}

}
