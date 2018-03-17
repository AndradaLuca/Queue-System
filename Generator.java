package tema2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

	private int maxServingTime;
	private int minServingTime;
	private int maxArrivingTime;
	private int minArrivingTime;
	

	Random random = new Random();

	public Generator(int maxServingTime,int minServingTime,int maxArrivingTime,int minArrivingTime)
	{
		this.maxArrivingTime=maxArrivingTime;
		this.maxServingTime=maxServingTime;
		this.minArrivingTime=minArrivingTime;
		this.minServingTime=minServingTime;
	}
	
	public Generator() {
		// TODO Auto-generated constructor stub
	}
	//generam random timpul de sosire si servire a clientului intre 2 parametri introdusi de la tastatura
	public Client genarare(int id,int maxServingTime,int minServingTime,int maxArrivingTime,int minArrivingTime)
	{
		int randomArrivingTime = ThreadLocalRandom.current().nextInt(minArrivingTime, maxArrivingTime + 1);
		int randomServingTime = ThreadLocalRandom.current().nextInt(minServingTime, maxServingTime + 1);
		
		Client client=new Client();
		client.setID(id);
		client.setArrivingTime(randomArrivingTime);
		client.setServingTime(randomServingTime);
		
		System.out.println("A fost generat" + client.toString());
		return client;
	}

}
