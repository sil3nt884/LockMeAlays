package com.rickyluu.locker;

public class TimerRunner implements Runnable {

	private Thread run;
	private boolean running = false;
	private SystemChecker check = new SystemChecker ();
	private int inactiveActvitySeconds = 0;
	
	
	public TimerRunner () {
		start();
	}
	
	
	public void start() {
		run = new Thread(this);
		running = true;
		run.start();

	}
	

	public void stop() throws InterruptedException {
		run.join();
		running = false;
		run = null;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		while (running) {
			long  now = System.currentTimeMillis();
			long seconds  = (now -  startTime ) / 1000;
			if(seconds == 1 ) {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				inactiveActvitySeconds = (int) check.getUserInactiveTime();
				 startTime = now;
				
			}
			
		}

	}


	public int getInactiveActvitySeconds() {
		return inactiveActvitySeconds;
	}


	public void setInactiveActvitySeconds(int inactiveActvitySeconds) {
		this.inactiveActvitySeconds = inactiveActvitySeconds;
	}

}
