package tema2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Market extends Thread {

	public static int timp;
	private int nrCozi = 0;
	private int nrClienti = 0;
	private int timpulSimularii;
	private int maxServingTime;
	private int minServingTime;
	private int maxArrivingTime;
	private int minArrivingTime;
	private JFrame marketSimulation;

	public static ArrayList<Client> listaClienti = new ArrayList<Client>();
	public static ArrayList<Coada> cozi = new ArrayList<Coada>();

	private static  int timpAsteptare = 0;
	private int oraDeVarf;
	private int timpTotalFaraClienti = 0;
	private double servire = 0;
	private shop interfata;

	public Market(int nrClienti, int nrCozi, int minArrivingTime, int maxArrivingTime, int minServingTime,
			int maxServingTime, int timpulSimularii) {

		this.nrClienti = nrClienti;
		this.maxArrivingTime = maxArrivingTime;
		this.minArrivingTime = minArrivingTime;
		this.maxServingTime = maxServingTime;
		this.minServingTime = minServingTime;
		this.timpulSimularii = timpulSimularii;
		this.nrCozi = nrCozi;

		for (int i = 0; i < nrCozi; i++) {
			Coada c = new Coada();
			cozi.add(c);

		}

	}
	
	//coada optima se alege dupa timpul total minim de servire 
	//clientul nou se va aseza la coada cu cel mai mic timp de servire in momentul sosiri lui
	
	public int coadaOptima()
	{
		int coadaOptima = 0;
		int minim=cozi.get(0).getTimpTotal();
		for(int i=0;i<cozi.size(); i++)
		{
			if(minim>cozi.get(i).getTimpTotal())
			{
				minim=cozi.get(i).getTimpTotal();
				coadaOptima=i;
			}
		}
		return coadaOptima;
	}
	
	public static void WaitingTime(int timp)
	{
		timpAsteptare=timpAsteptare+timp;
	}
	
	public double averageWaitingTime()
	{
		return timpAsteptare/nrClienti;
	}
	
	public static int getTimp()
	{
		return timp;
	}
	
	//claculam nr maxim de clienti la un anumit timp
	public int peakTime()
	{	int nrClienti=0;
		int nrMaxClienti=0;
		int i=0;
		while(i!=nrCozi)
		{
			nrClienti=nrClienti+ cozi.get(i).size();
			i++;
		}
		
		if(nrClienti>nrMaxClienti)
		{
			nrMaxClienti=nrClienti;
			oraDeVarf=timp;
		}
		return oraDeVarf;
	}
	//timpul mediu de servire
	//adunam timpul total de servire de la fiecare coada si impartim la nrClienti
	public double timpServire()
	{
		for(int i=0; i<nrCozi; i++)
		{
			servire=servire+cozi.get(i).getTotalServingTime();
		}
		return servire/nrClienti;
	}
	
	public int coadaGoala()
	{
		for(int i=0; i<nrCozi; i++)
		{
			timpTotalFaraClienti+=cozi.get(i).getCoadaGoala();
		}
		return timpTotalFaraClienti/nrCozi;
	}

	
	
	
	@Override

	public void run() {

		 marketSimulation = new JFrame();
		 marketSimulation.setBounds(400, 400, 800, 600);
		
		 
		 marketSimulation.setTitle("Market");
		 marketSimulation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		 
		 marketSimulation.add(interfata = new shop());
		 marketSimulation.setVisible(true);

		for (int i = 0; i <=nrClienti; i++) {
			Generator generator = new Generator();
			Client client=new Client();
					client=generator.genarare(i+1, maxServingTime, minServingTime, maxArrivingTime, minArrivingTime);
					listaClienti.add(client);
			
		}

		for (Coada c : cozi) {
			c.start();

		}
		for ( timp = 0; timp <= timpulSimularii; timp++) {

			for (Client client : listaClienti) {
				
				
				if (client.getArrivingTime() == timp) {
					int coadaOptima=this.coadaOptima();
					
					Gui.output.append(client.toString()+ " s-a asezat la coada " + coadaOptima +"\n");
					cozi.get(coadaOptima).addClient(client);
				
					interfata.coloreaza();	
				}	
				
				
			}
			peakTime();
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
		//scriere in textArea
		Gui.output.append("\n\n");
		for (Client client : listaClienti) {
			
			Gui.output.append(client.toString()+" a asteptat " + client.getWaitingTime()+ " si a plecat la "+ client.getTimpPlecare()+"\n");
		}
			Gui.output.append("Average waiting time " +averageWaitingTime()+"\n");
			Gui.output.append("Average Serving Time " + timpServire()+"\n");
			Gui.output.append("Ora de varf " + oraDeVarf+"\n" );
			Gui.output.append("Average Empty Time " + coadaGoala()+"\n");
			
			for (Client client : listaClienti) {
		System.out.println(client.toString()+" a asteptat " + client.getWaitingTime()+ " si a plecat la "+ client.getTimpPlecare());}
		System.out.println("Average waiting time " +averageWaitingTime());
		System.out.println("Ora de varf " + oraDeVarf );
		System.out.println("Average Serving Time " + timpServire() );
		System.out.println("Average Empty Time " + coadaGoala() );
		
	
	
}

	
	
	
}
