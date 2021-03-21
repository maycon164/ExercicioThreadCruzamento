package application;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class Programa {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		Thread c1 = new Cruzamento(1, "SUL", "NORTE", semaforo);
		Thread c2 = new Cruzamento(2, "NORTE", "SUL", semaforo);
		Thread c3 = new Cruzamento(3, "OESTE", "LESTE", semaforo);
		Thread c4 = new Cruzamento(4, "LESTE", "OESTE", semaforo);
	}
}
