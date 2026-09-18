package phan03;

public class Bai05 {
	public static void main(String[] args) {
		int a = 24, b = 36;
		int aOriginal = a, bOriginal = b;
		while (b != 0) {
		    int temp = b;
		    b = a % b;
		    a = temp;
		}
		System.out.println("USCLN của " + aOriginal + " và " + bOriginal + " là: " + a);
	}

}
