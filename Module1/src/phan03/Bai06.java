package phan03;

public class Bai06 {
	public static void main(String[] args) {
		int n = 11;
		boolean isPrime = true;
		if (n < 2) isPrime = false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
		    if (n % i == 0) {
		        isPrime = false;
		        break;
		    }
		}
		System.out.println(n + (isPrime ? " là số nguyên tố." : " không phải số nguyên tố."));
	}

}
