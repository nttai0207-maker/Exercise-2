package Bai02MD3;

import java.util.ArrayList;
import java.util.Scanner;

// LỚP SÁCH
class Sach {
    protected String maSach;
    protected String ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach(String maSach, String ngayNhap, double donGia,
                int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public double thanhTien() {
        return 0;
    }

    public void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
}

// LỚP SÁCH GIÁO KHOA
class SachGiaoKhoa extends Sach {

    private String tinhTrang;

    public SachGiaoKhoa(String maSach, String ngayNhap,
                        double donGia, int soLuong,
                        String nhaXuatBan, String tinhTrang) {

        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    // Nếu mới: thành tiền = số lượng * đơn giá
    // Nếu cũ: thành tiền = số lượng * đơn giá * 50%
    @Override
    
    public double thanhTien() {

        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    @Override
    
    public void xuat() {
        System.out.println("----- SACH GIAO KHOA -----");

        super.xuat();

        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + thanhTien());
    }
}



// LỚP SÁCH THAM KHẢO
class SachThamKhao extends Sach {

    private double thue;

    public SachThamKhao(String maSach, String ngayNhap,
                        double donGia, int soLuong,
                        String nhaXuatBan, double thue) {

        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    // Thành tiền = số lượng * đơn giá + thuế
    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void xuat() {
        System.out.println("----- SACH THAM KHAO -----");

        super.xuat();

        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + thanhTien());
    }
}



// LỚP QUẢN LÝ THƯ VIỆN
class ThuVien {

    private ArrayList<Sach> danhSach;

    public ThuVien() {
        danhSach = new ArrayList<>();
    }

    // Thêm sách vào danh sách
    public void themSach(Sach sach) {
        danhSach.add(sach);
    }

    // Xuất toàn bộ danh sách
    public void xuatDanhSach() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           DANH SACH CAC LOAI SACH");
        System.out.println("==========================================");

        for (Sach sach : danhSach) {
            sach.xuat();
            System.out.println();
        }
    }

    // Xuất các sách giáo khoa của nhà xuất bản K
    public void xuatSachGiaoKhoaNhaXuatBanK() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("     SACH GIAO KHOA CUA NHA XUAT BAN K");
        System.out.println("==========================================");

        boolean timThay = false;

        for (Sach sach : danhSach) {

            if (sach instanceof SachGiaoKhoa
                    && sach.getNhaXuatBan().equalsIgnoreCase("K")) {

                sach.xuat();
                System.out.println();

                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong co sach giao khoa cua NXB K.");
        }
    }

    // Tìm thành tiền cao nhất
    public double timThanhTienCaoNhat() {

        if (danhSach.size() == 0) {
            return 0;
        }

        double max = danhSach.get(0).thanhTien();

        for (Sach sach : danhSach) {

            if (sach.thanhTien() > max) {
                max = sach.thanhTien();
            }
        }

        return max;
    }

    // Xuất sách có thành tiền cao nhất
    public void xuatSachThanhTienCaoNhat() {

        double max = timThanhTienCaoNhat();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       SACH CO THANH TIEN CAO NHAT");
        System.out.println("==========================================");

        System.out.println("Thanh tien cao nhat: " + max);
        System.out.println();

        for (Sach sach : danhSach) {

            if (sach.thanhTien() == max) {
                sach.xuat();
                System.out.println();
            }
        }
    }
}



// CLASS MAIN
public class Baitap02MD3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ThuVien thuVien = new ThuVien();

        
        // TẠO 3 SÁCH GIÁO KHOA
       SachGiaoKhoa sgk1 = new SachGiaoKhoa(
                "GK01",
                "01/09/2026",
                100000,
                10,
                "K",
                "moi"
        );

        SachGiaoKhoa sgk2 = new SachGiaoKhoa(
                "GK02",
                "02/09/2026",
                120000,
                5,
                "K",
                "cu"
        );

        SachGiaoKhoa sgk3 = new SachGiaoKhoa(
                "GK03",
                "03/09/2026",
                150000,
                8,
                "NXB Giao Duc",
                "moi"
        );

        // Thêm vào thư viện
        thuVien.themSach(sgk1);
        thuVien.themSach(sgk2);
        thuVien.themSach(sgk3);


        
        // TẠO 3 SÁCH THAM KHẢO       
        SachThamKhao stk1 = new SachThamKhao(
                "TK01",
                "04/09/2026",
                200000,
                5,
                "NXB Tre",
                50000
        );

        SachThamKhao stk2 = new SachThamKhao(
                "TK02",
                "05/09/2026",
                250000,
                10,
                "K",
                100000
        );

        SachThamKhao stk3 = new SachThamKhao(
                "TK03",
                "06/09/2026",
                180000,
                4,
                "NXB Tre",
                30000
        );

        // Thêm vào thư viện
        thuVien.themSach(stk1);
        thuVien.themSach(stk2);
        thuVien.themSach(stk3);


        
        // XUẤT TOÀN BỘ DANH SÁCH
        thuVien.xuatDanhSach();
        
        // XUẤT SÁCH GIÁO KHOA CỦA NXB K
        thuVien.xuatSachGiaoKhoaNhaXuatBanK();


       
        //TÌM THÀNH TIỀN CAO NHẤT
        thuVien.xuatSachThanhTienCaoNhat();


        sc.close();
    }
}