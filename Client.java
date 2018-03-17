package tema2;

public class Client {
	
	
	private int id;
	private int arrivingTime;
	private int servingTime;
	private int waitingTime=0;
	private int timpPlecare;
	
	
	public Client(){
	
	}

	public Client(int id, int arrivingTime, int servingTime, int waitingTime)
	{
		this.id=id;
		this.arrivingTime=arrivingTime;
		this.servingTime=servingTime;
		this.waitingTime=waitingTime;
	}
	
	
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setID(int ID) {
		this.id = ID;
	}

	public void setArrivingTime(int arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public void setServingTime(int servingTime) {
		this.servingTime = servingTime;
	}

	public int getID() {
		return id;
	}

	public int getArrivingTime() {
		return arrivingTime;
	}

	public int getServingTime() {
		return servingTime;
	}
	
	public void setTimpPlecare(int x)
	{
		this.timpPlecare=x;
	}
	
	public int getTimpPlecare()
	{
		return timpPlecare;
	}

	public String toString() {
		
  return "Client " + getID() + " timp sosire " + getArrivingTime() + " timp servire " + getServingTime() ;
	
	}
	
	public int getTimp()
	{
		return getServingTime() + getArrivingTime();
	}
	
	
}
