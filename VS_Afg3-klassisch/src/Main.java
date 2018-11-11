
public class Main {

	private static int n = 10;
	private static int k = 2;
	
	private static long startZeit; // in ns
	private static long endZeit;
	
	public static int binKoeff(int n, int k) {
/*		if (k==0) return 1; // k=0 -> 1
		if (k==1) return n; // k=1 -> n
		else if (k>n) return 0; // stets n >=k 
		else return binKoeff(n-1,k-1) + binKoeff(n-1,k); */
		
		if (k>n) return 0; // stets n >=k 
		switch (k) {
		case 0: return 1; // k=0 -> 1
		case 1: return n; // k=1 -> n
		default: return binKoeff(n-1,k-1) + binKoeff(n-1,k); // Formel
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startZeit = System.nanoTime();
		System.out.println("Ergebnis: " + binKoeff(n,k));
		endZeit = System.nanoTime();
		System.out.println("Laufzeit: "+ (endZeit - startZeit) + " Nanosekunden");
	}

}
