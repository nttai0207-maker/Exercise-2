package Bai04MD4;

import java.util.ArrayList;
import java.util.Comparator;

//LỚP SINH VIÊn
class SinhVien {
    private String maSv;
    private String hoTen;
    private int namSinh;

    public SinhVien(String maSv, String hoTen, int namSinh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public String getMaSv() {
        return maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "Mã SV: " + maSv + ", Họ tên: " + hoTen + ", Năm sinh: " + namSinh;
    }
}

//LỚP QUẢN LÝ SINH VIÊN
class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSv;

    public QuanLySinhVien() {
        danhSachSv = new ArrayList<>();
        
        // Khởi tạo sẵn 5 sinh viên (không trùng mã)
        danhSachSv.add(new SinhVien("SV01", "Nguyễn Văn An", 2003));
        danhSachSv.add(new SinhVien("SV02", "Trần Thị Bình", 2004));
        danhSachSv.add(new SinhVien("SV03", "Lê Hoàng Cường", 2002));
        danhSachSv.add(new SinhVien("SV04", "Phạm Thị Dung", 2003));
        danhSachSv.add(new SinhVien("SV05", "Hoàng Văn Em", 2001));
    }

    public ArrayList<SinhVien> layDanhSach() {
        return danhSachSv;
    }

    public boolean themSinhVien(SinhVien sv) {
        for (SinhVien s : danhSachSv) {
            if (s.getMaSv().equalsIgnoreCase(sv.getMaSv())) {
                return false;
            }
        }
        danhSachSv.add(sv);
        return true;
    }

    public boolean xoaSinhVien(String maSv) {
        for (SinhVien s : danhSachSv) {
            if (s.getMaSv().equalsIgnoreCase(maSv)) {
                danhSachSv.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean suaSinhVien(String maSv, String hoTenMoi, int namSinhMoi) {
        for (SinhVien s : danhSachSv) {
            if (s.getMaSv().equalsIgnoreCase(maSv)) {
                s.setHoTen(hoTenMoi);
                s.setNamSinh(namSinhMoi);
                return true;
            }
        }
        return false;
    }

    public SinhVien timKiemTheoMa(String maSv) {
        for (SinhVien s : danhSachSv) {
            if (s.getMaSv().equalsIgnoreCase(maSv)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<SinhVien> timKiemTheoTen(String ten) {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien s : danhSachSv) {
            if (s.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(s);
            }
        }
        return ketQua;
    }

    public void sapXepTheoMaTangDan() {
        danhSachSv.sort(Comparator.comparing(SinhVien::getMaSv));
    }
}

//LỚP CHÍNH
public class Baitap04MD4 {
    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();

        System.out.println("=== DANH SÁCH 5 SINH VIÊN BAN ĐẦU ===");
        for (SinhVien sv : qlsv.layDanhSach()) {
            System.out.println(sv);
        }

        System.out.println("\n=== THÊM SINH VIÊN MỚI (SV06) ===");
        SinhVien svMoi = new SinhVien("SV06", "Vũ Thị Phương", 2004);
        if (qlsv.themSinhVien(svMoi)) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại (Trùng mã)!");
        }

        System.out.println("\n=== SỬA THÔNG TIN SINH VIÊN (Mã: SV02) ===");
        boolean daSua = qlsv.suaSinhVien("SV02", "Trần Thị Bình Minh", 2004);
        if (daSua) {
            System.out.println("Sửa thông tin thành công!");
        } else {
            System.out.println("Không tìm thấy mã sinh viên cần sửa!");
        }

        System.out.println("\n=== TÌM KIẾM THEO MÃ (SV03) ===");
        SinhVien kqMa = qlsv.timKiemTheoMa("SV03");
        if (kqMa != null) {
            System.out.println("Kết quả: " + kqMa);
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }

        System.out.println("\n=== TÌM KIẾM THEO TÊN ('An') ===");
        ArrayList<SinhVien> kqTen = qlsv.timKiemTheoTen("An");
        for (SinhVien sv : kqTen) {
            System.out.println(sv);
        }

        System.out.println("\n=== DANH SÁCH SAU KHI SẮP XẾP MÃ TĂNG DẦN ===");
        qlsv.sapXepTheoMaTangDan();
        for (SinhVien sv : qlsv.layDanhSach()) {
            System.out.println(sv);
        }

        System.out.println("\n=== XÓA SINH VIÊN (Mã: SV01) ===");
        boolean daXoa = qlsv.xoaSinhVien("SV01");
        if (daXoa) {
            System.out.println("Xóa thành công! Danh sách còn lại:");
            for (SinhVien sv : qlsv.layDanhSach()) {
                System.out.println(sv);
            }
        } else {
            System.out.println("Không tìm thấy mã sinh viên cần xóa!");
        }
    }
}