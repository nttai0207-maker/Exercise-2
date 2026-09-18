package phan02;

public class PrePostDemo {
	public static void main(String[] args) {
        int i = 3;
        i++; // i tăng lên 4
        System.out.println(i); 
        // Xuất ra: 4
        
        ++i; 
        // i tăng lên 5
        System.out.println(i); 
        // Xuất ra: 5
        
        System.out.println(++i); 
       
        System.out.println(i++); 
       
        System.out.println(--i); 
        
        System.out.println(i--);
        
        System.out.println(i);  
        
    }
}
