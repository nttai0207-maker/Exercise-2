package phan03;

public class Bai08 {
	public static void main(String[] args) {
		String s = "Lập trình java cơ bản";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) == 'a') {
		        count++;
		    }
		}
		System.out.println("Số lần xuất hiện ký tự 'a': " + count);
	}

}
