package java_36;

public class Main {
    public static void main(String[] args) {
        NgayChieu ngay1 = new NgayChieu(12, 2, 2022);
        NgayChieu ngay2 = new NgayChieu(25, 6, 2023);
        NgayChieu ngay3 = new NgayChieu(30, 12, 2023);

        HangSanXuat hang1 = new HangSanXuat("Disney", "Anh");
        HangSanXuat hang2 = new HangSanXuat("Holleywood", "My");
        HangSanXuat hang3 = new HangSanXuat("viet", "Viet Nam");

        MotBoPhim phim1 = new MotBoPhim("nguoi vo cuoi cung", 2023, hang1, 75, ngay1);
        MotBoPhim phim2 = new MotBoPhim("Tet o lang dia nguc", 2022, hang2, 50, ngay2);
        MotBoPhim phim3 = new MotBoPhim("Doremon", 1996, hang3, 100, ngay3);

        System.out.println("Kiem tra gia ve cua phim 1 co re hon phim 2 khong: " + phim1.kiemTraGiaVeReHon(phim2));
        System.out.println("Kiem tra gia ve cua phim 1 co re hon phim 3 khong: " + phim1.kiemTraGiaVeReHon(phim3));

        System.out.println("Ten hang san xua cua phim 1 la: " );
        phim1.inTenHangSanXuat();

        System.out.println("Ten hang san xuat cua phim 2 la: ");
        phim2.inTenHangSanXuat();

        System.out.println("Ten hang san xuat cua phim 3 la: ");
        phim3.inTenHangSanXuat();

        System.out.println("Gia ve cua phim 1 sau khuyen mai 5% la: " + phim1.giaVeKhiKhuyenMai(5));
        System.out.println("Gia ve cua phim 2 sau khuyen mai 10% la: " + phim2.giaVeKhiKhuyenMai(10));
        System.out.println("Gia ve cua phim 3 sau khuyen mai 15% la: " + phim3.giaVeKhiKhuyenMai(15));
        
    }
}
