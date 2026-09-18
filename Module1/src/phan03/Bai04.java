package phan03;

public class Bai04 {
	public static void main(String[] args) {
		double a = 2.0, b = -4.0;
		if (a == 0) {
		    if (b == 0) System.out.println("Phương trình vô số nghiệm.");
		    else System.out.println("Phương trình vô nghiệm.");
		} else {
		    double x = -b / a;
		    System.out.println("Nghiệm x = " + x);
		}
	}

}
