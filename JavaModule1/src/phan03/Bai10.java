package phan03;

public class Bai10 {
	public static void main(String[] args) {
		String s = "Java123Cod456";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
		    if (Character.isDigit(s.charAt(i))) {
		        count++;
		    }
		}
		System.out.println("Số lượng ký tự là số: " + count);
	}

}
