package phan03;

public class Bai07 {
	public static void main(String[] args) {
		int N = 20;
		int sum = 0;
		for (int i = 2; i < N; i++) {
		    boolean prime = true;
		    for (int j = 2; j <= Math.sqrt(i); j++) {
		        if (i % j == 0) { prime = false; break; }
		    }
		    if (prime) sum += i;
		}
		System.out.println("Tổng các số nguyên tố nhỏ hơn " + N + " là: " + sum);
	}

}
