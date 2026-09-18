package phan01;

//Khai báo Scanner
	import java.util.Scanner;

public class Bai02 {	
	
	    public static void main(String[] args) {
	        // Khởi tạo đối tượng Scanner
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Nhập tên của bạn: ");
	        String ten = scanner.nextLine();
	        
	        // Xuất kết quả
	        System.out.println("Hello " + ten);
	        
	        // Đóng scanner
	        scanner.close();
}
}
