package com.hari.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(4);
		Phaser phaser = new Phaser(3);
		eService.submit(new PhaserService(phaser));
		eService.submit(new PhaserService(phaser));
		eService.submit(new PhaserService(phaser));

		phaser.awaitAdvance(1);

		System.out.println(" PhaserTest Done !!!");

	}

}
