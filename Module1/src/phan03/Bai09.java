package phan03;

public class Bai09 {
	public static void main(String[] args) {
		String s = " Lap Trinh HDT";
		String[] parts = s.trim().split("\\s+");
		for (String p : parts) {
		    System.out.println(p);
		}
	}

}
