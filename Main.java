package tema2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Market test = new Market(16, 3, 2, 20, 1, 15, 60);
		
		//Market(int nrClienti, int nrCozi, int minArrivingTime, int maxArrivingTime, int minServingTime,
		//int maxServingTime, int timpulSimularii)

		test.start();

	}

}
