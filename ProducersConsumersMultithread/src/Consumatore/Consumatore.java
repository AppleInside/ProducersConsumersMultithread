package Consumatore;

import Test.Magazzino;

public class Consumatore extends Thread{
	
	// Appoggio per l'oggetto condiviso
	Magazzino mag;
	
	public Consumatore(Magazzino m) {
		this.mag = m;
	}

	@Override
	public void run() {
		
		while(!this.isInterrupted()) {
			
			// Creo una sequenza sincrona, che verrà esguita in mutua esclusione
			synchronized(mag) {
				if(!mag.isEmpty()) {
					mag.remove();
					System.out.println("[Consumatore]	->	Inserisco qualcosa nel contenitore");
				}

				// Risveglio tutti i produttori/consumatori
				mag.notifyAll();

				// Mi metto in attesa di notifiche!
				try {
					mag.wait();
					System.out.println("[Consumatore]	->	wait()");
				}catch(InterruptedException e) {
					e.printStackTrace();
					this.interrupt();
				}
				
			}
		}
		System.out.println("[Consumatore]	->	Produttore interrotto");
	}
}
