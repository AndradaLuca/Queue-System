package tema2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Coada extends Thread {

	private ArrayList<Client> coadaClienti = new ArrayList<Client>();

	// timpul total de servire pentru fiecare coada in functie de cati clienti se afla 
	//pentru a putea stabili coada cea mai optima
	// pentru a sti la ce coada se va aseza urmatorul client
	private int timpTotalCoada = 0;
	private int timpCoadaGoala = 0;
	private int timpServire=0;

	public int getTimpTotal() {
		return timpTotalCoada;
	}

	public void addClient(Client client) {
		timpTotalCoada += client.getServingTime();
		timpServire+=client.getServingTime();
		coadaClienti.add(client);
	}

	//stergem primul client de la coada
	public void removeClient() {
		timpTotalCoada -= coadaClienti.get(0).getServingTime();
		coadaClienti.remove(0);
	}
	
	public int size()
	{
		 return coadaClienti.size();
	}
	//timpul total de servire dintr-o coada pt a putea calcula timpul mediu de servire
	public int getTotalServingTime()
	{
		return timpServire;
	}
	
	//timpul cat coada nu a avut clienti
	public  void coadaGoala()
	{
		timpCoadaGoala++;
	}

	public int getCoadaGoala()
	{
		return timpCoadaGoala;
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (coadaClienti.isEmpty()) {

				// daca coada este goala asteapta 1 secunda
				try {
					coadaGoala();
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (!coadaClienti.isEmpty()) {
				// daca coada nu e goala asteapta timpul de servire a primului
				// client de la coada
				try {
					TimeUnit.SECONDS.sleep(coadaClienti.get(0).getServingTime());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//	calculam timpul de asteptare si timpul plecarii fiecarui client
				int asteptare=Market.getTimp() - coadaClienti.get(0).getTimp();
				Market.WaitingTime(asteptare);
				
				coadaClienti.get(0).setWaitingTime(asteptare);
				int timpPlecare=Market.getTimp();
			coadaClienti.get(0).setTimpPlecare(timpPlecare);
				this.removeClient();
			}
		}

	}

}
