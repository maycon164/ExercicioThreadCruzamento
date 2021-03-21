package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread{
	
	private int id;
	private String inicio;
	private String fim;
	private Semaphore semaforo;
	
	public Cruzamento(int id, String inicio, String fim, Semaphore semaforo) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.semaforo = semaforo;
		this.start();
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			atravessarCruzamento();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	private synchronized void atravessarCruzamento() throws InterruptedException {
		System.out.println("Carro #" + id + " está no " + inicio);
		sleep(1000);
		System.out.println("Carro #" + id + " está atravessando o cruzamento");
		sleep(1000);
		System.out.println("Carro #" + id + " chegou no lado " + fim);
		sleep(1000);
		System.out.println();
	}
}
