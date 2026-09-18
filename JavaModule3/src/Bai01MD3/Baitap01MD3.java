package Bai01MD3;

import java.util.ArrayList;

class ChuyenXe {
    String maSoChuyen;
    String hoTenTaiXe;
    String soXe;
    double doanhThu;

    public ChuyenXe(String maSoChuyen, String hoTenTaiXe,
                    String soXe, double doanhThu) {

        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }
}

class ChuyenXeNoiThanh extends ChuyenXe {
    String soTuyen;
    double soKm;

    public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe,
                            String soXe, String soTuyen,
                            double soKm, double doanhThu) {

        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);

        this.soTuyen = soTuyen;
        this.soKm = soKm;
    }
}

class ChuyenXeNgoaiThanh extends ChuyenXe {
    String noiDen;
    int soNgay;

    public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe,
                              String soXe, String noiDen,
                              int soNgay, double doanhThu) {

        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);

        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }
}

public class Baitap01MD3 {

    public static void main(String[] args) {

        ArrayList<ChuyenXeNoiThanh> dsNoiThanh = new ArrayList<>();
        ArrayList<ChuyenXeNgoaiThanh> dsNgoaiThanh = new ArrayList<>();

        // Tao 2 chuyen xe noi thanh
        dsNoiThanh.add(new ChuyenXeNoiThanh(
                "NT01",
                "Nguyen Van A",
                "71A-12345",
                "T01",
                30,
                500000
        ));

        dsNoiThanh.add(new ChuyenXeNoiThanh(
                "NT02",
                "Tran Van B",
                "71A-67890",
                "T02",
                45,
                700000
        ));

        // Tao 2 chuyen xe ngoai thanh
        dsNgoaiThanh.add(new ChuyenXeNgoaiThanh(
                "NG01",
                "Le Van C",
                "71B-11111",
                "TP.HCM",
                2,
                1500000
        ));

        dsNgoaiThanh.add(new ChuyenXeNgoaiThanh(
                "NG02",
                "Pham Van D",
                "71B-22222",
                "Can Tho",
                3,
                2000000
        ));

        double tongNoiThanh = 0;
        double tongNgoaiThanh = 0;

        // Tinh doanh thu noi thanh
        for (ChuyenXeNoiThanh xe : dsNoiThanh) {
            tongNoiThanh += xe.doanhThu;
        }

        // Tinh doanh thu ngoai thanh
        for (ChuyenXeNgoaiThanh xe : dsNgoaiThanh) {
            tongNgoaiThanh += xe.doanhThu;
        }

        double tongDoanhThu = tongNoiThanh + tongNgoaiThanh;

        System.out.println("Tong doanh thu noi thanh: " + tongNoiThanh);
        System.out.println("Tong doanh thu ngoai thanh: " + tongNgoaiThanh);
        System.out.println("Tong doanh thu tat ca: " + tongDoanhThu);
    }
}