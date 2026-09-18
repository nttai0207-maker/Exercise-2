package Bai03MD3;

import java.util.ArrayList;


// LỚP GIAO DỊCH
class GiaoDich {

    protected String maGiaoDich;
    protected String ngayGiaoDich;
    protected double donGia;
    protected int soLuong;

    public GiaoDich(String maGiaoDich, String ngayGiaoDich,
                    double donGia, int soLuong) {

        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Phương thức tính thành tiền
    public double thanhTien() {
        return 0;
    }

    public void xuat() {
        System.out.println("Ma giao dich: " + maGiaoDich);
        System.out.println("Ngay giao dich: " + ngayGiaoDich);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
    }

    public double getDonGia() {
        return donGia;
    }
}



// LỚP GIAO DỊCH VÀNG
class GiaoDichVang extends GiaoDich {

    private String loaiVang;

    public GiaoDichVang(String maGiaoDich, String ngayGiaoDich,
                        double donGia, int soLuong,
                        String loaiVang) {

        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    // Thành tiền = số lượng * đơn giá
    @Override
    public double thanhTien() {
        return soLuong * donGia;
    }

    @Override
    public void xuat() {

        System.out.println("----- GIAO DICH VANG -----");

        super.xuat();

        System.out.println("Loai vang: " + loaiVang);
        System.out.println("Thanh tien: " + thanhTien());
    }
}



// LỚP GIAO DỊCH TIỀN TỆ
class GiaoDichTienTe extends GiaoDich {

    private double tiGia;
    private String loaiTienTe;

    public GiaoDichTienTe(String maGiaoDich, String ngayGiaoDich,
                           double donGia, int soLuong,
                           double tiGia, String loaiTienTe) {

        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    // Nếu USD hoặc Euro: => Thành tiền = số lượng * đơn giá * tỉ giá
   
    // Nếu VN => Thành tiền = số lượng * đơn giá
    @Override
    public double thanhTien() {

        if (loaiTienTe.equalsIgnoreCase("USD")
                || loaiTienTe.equalsIgnoreCase("Euro")) {

            return soLuong * donGia * tiGia;
        }

        // VN
        return soLuong * donGia;
    }

    @Override
    public void xuat() {

        System.out.println("----- GIAO DICH TIEN TE -----");

        super.xuat();

        System.out.println("Ti gia: " + tiGia);
        System.out.println("Loai tien te: " + loaiTienTe);
        System.out.println("Thanh tien: " + thanhTien());
    }
}



// LỚP QUẢN LÝ DANH SÁCH GIAO DỊCH
class QuanLyGiaoDich {

    private ArrayList<GiaoDich> danhSach;

    public QuanLyGiaoDich() {
        danhSach = new ArrayList<>();
    }

    // Thêm giao dịch
    public void themGiaoDich(GiaoDich giaoDich) {
        danhSach.add(giaoDich);
    }


    
    //  Tính tổng số lượng của từng loại
    public void tinhTongSoLuong() {

        int tongVang = 0;
        int tongTienTe = 0;

        for (GiaoDich giaoDich : danhSach) {

            if (giaoDich instanceof GiaoDichVang) {

                tongVang += giaoDich.soLuong;

            } else if (giaoDich instanceof GiaoDichTienTe) {

                tongTienTe += giaoDich.soLuong;
            }
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       TONG SO LUONG TUNG LOAI");
        System.out.println("==========================================");

        System.out.println("Tong so luong giao dich vang: " + tongVang);
        System.out.println("Tong so luong giao dich tien te: " + tongTienTe);
    }


   
    // Tính trung bình thành tiền của giao dịch tiền tệ
    public void tinhTrungBinhTienTe() {

        double tong = 0;
        int dem = 0;

        for (GiaoDich giaoDich : danhSach) {

            if (giaoDich instanceof GiaoDichTienTe) {

                tong += giaoDich.thanhTien();
                dem++;
            }
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("    TRUNG BINH THANH TIEN GIAO DICH");
        System.out.println("             TIEN TE");
        System.out.println("==========================================");

        if (dem > 0) {

            double trungBinh = tong / dem;

            System.out.println("Trung binh thanh tien: " + trungBinh);

        } else {

            System.out.println("Khong co giao dich tien te.");
        }
    }


   
    // Xuất giao dịch có đơn giá > 1 tỷ 
    public void xuatDonGiaLonHonMotTy() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("    GIAO DICH CO DON GIA > 1 TY");
        System.out.println("==========================================");

        boolean timThay = false;

        for (GiaoDich giaoDich : danhSach) {

            if (giaoDich.getDonGia() > 1000000000) {

                giaoDich.xuat();
                System.out.println();

                timThay = true;
            }
        }

        if (!timThay) {

            System.out.println("Khong co giao dich nao co don gia > 1 ty.");
        }
    }


    
    // Xuất toàn bộ giao dịch
    public void xuatDanhSach() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          DANH SACH GIAO DICH");
        System.out.println("==========================================");

        for (GiaoDich giaoDich : danhSach) {

            giaoDich.xuat();

            System.out.println();
        }
    }
}



// CLASS MAIN
public class Baitap03MD3 {

    public static void main(String[] args) {

        // Tạo đối tượng quản lý
        QuanLyGiaoDich quanLy = new QuanLyGiaoDich();


        
        // TẠO 3 GIAO DỊCH VÀNG
        GiaoDichVang vang1 = new GiaoDichVang(
                "V01",
                "01/09/2026",
                80000000,
                10,
                "SJC"
        );

        GiaoDichVang vang2 = new GiaoDichVang(
                "V02",
                "02/09/2026",
                1200000000,
                2,
                "9999"
        );

        GiaoDichVang vang3 = new GiaoDichVang(
                "V03",
                "03/09/2026",
                95000000,
                5,
                "PNJ"
        );


        // Thêm giao dịch vàng
        quanLy.themGiaoDich(vang1);
        quanLy.themGiaoDich(vang2);
        quanLy.themGiaoDich(vang3);


        
        // TẠO 3 GIAO DỊCH TIỀN TỆ
        GiaoDichTienTe tien1 = new GiaoDichTienTe(
                "T01",
                "04/09/2026",
                23000,
                1000,
                1,
                "USD"
        );

        GiaoDichTienTe tien2 = new GiaoDichTienTe(
                "T02",
                "05/09/2026",
                27000,
                500,
                1,
                "Euro"
        );

        GiaoDichTienTe tien3 = new GiaoDichTienTe(
                "T03",
                "06/09/2026",
                25000000,
                10,
                1,
                "VN"
        );


        // Thêm giao dịch tiền tệ
        quanLy.themGiaoDich(tien1);
        quanLy.themGiaoDich(tien2);
        quanLy.themGiaoDich(tien3);


        
        // XUẤT TOÀN BỘ DANH SÁCH
   
        quanLy.xuatDanhSach();


        
        // a. TỔNG SỐ LƯỢNG TỪNG LOẠI

        quanLy.tinhTongSoLuong();


        
        //  TRUNG BÌNH THÀNH TIỀN GIAO DỊCH TIỀN TỆ

        quanLy.tinhTrungBinhTienTe();


 
        //  XUẤT GIAO DỊCH CÓ ĐƠN GIÁ > 1 TỶ
    
        quanLy.xuatDonGiaLonHonMotTy();
    }
}