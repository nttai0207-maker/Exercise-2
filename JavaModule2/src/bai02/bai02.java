package bai02;

// 1. Lớp Point bên ngoài
class Point {
    private double x;
    private double y;

    // Constructor mặc định 
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor đầy đủ tham số
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    // Hàm negate - đổi dấu tọa độ 
    public void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    // Hàm getDistance - tính khoảng cách từ gốc O(0,0)
    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }

    // trả về thông tin tọa độ ( toString)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


public class bai02 {
    public static void main(String[] args) {
        // Tạo đối tượng Point
        Point p = new Point(3.0, 4.0);
        System.out.println("Điểm ban đầu: " + p);
        
        // Tính khoảng cách từ gốc O
        System.out.println("Khoảng cách từ gốc O: " + p.getDistance());

        // Biến đổi đối xứng qua gốc O bằng hàm negate()
        p.negate();
        System.out.println("Điểm sau khi đối xứng (negate): " + p);
    }
}