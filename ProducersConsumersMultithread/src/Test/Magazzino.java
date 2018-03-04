/*
 * Questa classe rappresenta l'oggetto condiviso tra i thread.
 * I metodi non sono definiti "synchronized" perchè uso direttamente le sequenze sincronizzate.
 * Ogni oggetto condiviso ha una coda di attesa, accessibile con wait() e notify()
 */


package Test;

import java.util.ArrayList;

public class Magazzino {
	
	private final int MAX_ELEMENTS = 10;
	  
	 private ArrayList<Integer> pool;
	 
	 public Magazzino() {
		 pool = new ArrayList<Integer>();
	 }
	  
	 public boolean isEmpty() {
		 return pool.isEmpty();
	 }
	 
	 public boolean isFull() {
		 if(pool.size()==MAX_ELEMENTS)
			 return true;
		 return false;
	 }
	 
	 public void remove() {
		 System.out.println("\t--> remove()");
		 pool.remove(pool.size()-1);
	 }
	 
	 public void add(Integer elem) {
		 System.out.println("\t--> add()");
		 pool.add(elem);
	 }
	  	  
}
