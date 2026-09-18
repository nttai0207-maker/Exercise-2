package phan02;

public class ComprisonDemo {
	public static void main(String[] args) {
        int value1 = 1;
        int value2 = 2;
        
        System.out.println("value1 == value2: " + (value1 == value2));
        // 1 == 2 -> Sai
        
        System.out.println("value1 != value2: " + (value1 != value2));
        // 1 khác 2 -> Đúng
        
        System.out.println("value1 > value2: " + (value1 > value2));
        // 1 > 2 -> Sai
        
        System.out.println("value1 < value2: " + (value1 < value2));   
        // 1 < 2 -> Đúng
        
        System.out.println("value1 <= value2: " + (value1 <= value2)); 
         //1 <= 2 -> Đúng
        
        System.out.println("(value1 <= value2) && (value1 == value2): " 
                + ((value1 <= value2) && (value1 == value2)));
        // Phép toán AND: 1 <= 2 Đúng nhưng 1 == 2 Sai -> Sai
        
        System.out.println("(value1 <= value2) || (value1 == value2): " 
                + ((value1 <= value2) && (value1 == value2)));
        //Phép toán AND: 1 <= 2 Đúng nhưng 1 == 2 Sai -> Sai
    }

}
