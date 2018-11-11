
public class Main {

	private static int n = 20;
	private static int k = 8;

	private static long startZeit; // in ns
	private static long endZeit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startZeit = System.nanoTime();
		Binomialkoeffizient hauptThread = new Binomialkoeffizient(n, k);
		try {
			hauptThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endZeit = System.nanoTime();
		System.out.println("Ergebnis: " + hauptThread.ergebnis);
		System.out.println("Erzeugte Unter-Threads: " + hauptThread.threadCounter);
		System.out.println("Laufzeit: " + (endZeit - startZeit) + " Nanosekunden");
	}

}
