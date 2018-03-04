package Test;

import Consumatore.Consumatore;
import Produttore.Produttore;

public class Test {

	private static final int CONS = 1, PROD = 1;
	
	
	
	public static void main(String[] args) {
		
		Magazzino magazzino = new Magazzino();
		Consumatore[] consumers = new Consumatore[CONS];
		Produttore[] producers = new Produttore[PROD];
		
		
		for (int i=0; i<Math.min(CONS, PROD); i++) {
			producers[i] = new Produttore(magazzino);
			producers[i].start();
			consumers[i] = new Consumatore(magazzino);
			consumers[i].start();
		}
		
		try {
	        Thread.sleep(10);
	    } catch (InterruptedException ex) {
	        ex.printStackTrace();
	    }
	 
		for (int i=0; i<Math.min(CONS, PROD); i++) {
			producers[i].interrupt();
			consumers[i].interrupt();
			try {
		        producers[i].join();
		        consumers[i].join();
		    } catch (InterruptedException ex) {
		        ex.printStackTrace();
		    }
		}
	    
		    
		System.out.println("DONE!");
	}

}
