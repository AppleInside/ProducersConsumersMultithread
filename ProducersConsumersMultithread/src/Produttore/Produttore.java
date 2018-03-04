package Produttore;

import java.util.Random;

import Test.Magazzino;

public class Produttore extends Thread{
	
	// Appoggio per l'oggetto condiviso
	Magazzino mag;
	
	public Produttore(Magazzino m) {
		this.mag = m;
	}
	
	
	@Override
	public void run() {
		
		while(!this.isInterrupted()) {
			
			// Creo una sequenza sincrona, che verrà esguita in mutua esclusione
			synchronized(mag) {
				if(!mag.isFull()) {
					mag.add(getRand(0,100));
					System.out.println("[Produttore]	->	Inserisco qualcosa nel contenitore");
				}

				// Risveglio tutti i produttori/consumatori
				mag.notifyAll();

				// Mi metto in attesa di notifiche!
				try {
					mag.wait();
					System.out.println("[Produttore]	->	wait()");
				}catch(InterruptedException e) {
					e.printStackTrace();
					this.interrupt();
				}
			}
		}
		System.out.println("[Produttore]	->	Produttore interrotto");
	}
	
	
	private static int getRand(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
