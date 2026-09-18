package phan03;

public class Bai03 {
	public static void main(String[] args) {
	int n = 5; 
	int sum = 0;
	if (n % 2 != 0) { //n lẻ: tính 1 + 3 + 5 + ... + n
	    for (int i = 1; i <= n; i += 2) sum += i;
	} else { //n chẵn: tính 2 + 4 + 6 + ... + n
	    for (int i = 2; i <= n; i += 2) sum += i;
	}
	System.out.println("Tổng: " + sum);

}
}
