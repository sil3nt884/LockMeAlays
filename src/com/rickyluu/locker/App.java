package com.rickyluu.locker;

public class App extends TimerRunner{
		
	boolean running = false;
	
	public App() throws InterruptedException {
		System.out.println("Proccess ID " +Kernel32.getProccessID(Kernel32.GetCurrentProcessHandle()));
		System.out.println("SET CPU ussage to 1" +Kernel32.setProccessAffinity(Kernel32.GetCurrentProcessHandle(), 1));
		running = true;
		while(running) {
			Thread.sleep(1000);
			userIsInactive();
		
		}
	}
	
	public static void main(String[] args) {
		try {
			new App();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void stopChecking() {
		running = false;
	}
	
	public void startChecking() {
		running = false;
	}
	
	public void userIsInactive() {
		int secondsInactive = this.getInactiveActvitySeconds();
		System.out.println("seconds "+secondsInactive);
		if(secondsInactive >=45 ) {
			System.out.println("lock this machine");
			secondsInactive = 0;
			User32.lockUser();
		}
		if(secondsInactive <60 ) {
			System.out.println("user still active.");
		}
		
	}


	

	

}
