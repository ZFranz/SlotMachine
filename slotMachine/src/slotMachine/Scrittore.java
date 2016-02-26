package slotMachine;

import java.util.Timer;
import java.util.TimerTask;

public class Scrittore extends TimerTask {
	private Timer tim;
	private static int contatore = 0;
	private int volte;
	private String msg;
	
	public Scrittore(String msg, int sec, int volte) {
		this.msg = msg;
		this.volte = volte;
	
		tim = new Timer();
		tim.schedule(this, 0, sec * 1000);
	}
	
	public void run() {
		contatore++;
	
		if(contatore >= volte) {
			tim.cancel();	// questa esecuzione di run() e' l'ultima
		}
	
		System.out.println(msg + " numero: " + contatore);
	}
	
	public static void main(String[] args) {
		// scrivi "Ciao" ogni secondo per 5 volte
		new Scrittore("Ciao", 1, 5);
	}
}