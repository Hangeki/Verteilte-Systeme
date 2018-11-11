
public class Binomialkoeffizient extends Thread {
	private int n;
	private int k;

	public int ergebnis;
	public int threadCounter; //

	public Binomialkoeffizient(int n, int k) {
		this.n = n;
		this.k = k;
		start();
		System.out.println("Starte Thread");
	}

	public void run() { // public int run/( geht nicht :(

		if (k > n - k) { //Endlosschleife ohne dieses if...
			k = n - k;
		}

		if (k == 0) {
			// System.out.println("k == 0");
			ergebnis = 1;
			return;
		}
		if (k == 1) {
			// System.out.println("k == 1");
			ergebnis = n;
			return;
		}

		else
			try { // unterThreads erzeugen
					// System.out.println("Anfang else-Block");
				Binomialkoeffizient subThread1 = new Binomialkoeffizient(n - 1, k - 1);
				threadCounter++;
				Binomialkoeffizient subThread2 = new Binomialkoeffizient(n - 1, k);
				threadCounter++;
				// warten bis beide fertig
				subThread1.join();
				subThread2.join();
				// System.out.println("joined");
				// Ergebnis zusammensetzen
				ergebnis = subThread1.ergebnis + subThread2.ergebnis;
				threadCounter += subThread1.threadCounter + subThread2.threadCounter;
				// System.out.println("Ende else-Block");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
