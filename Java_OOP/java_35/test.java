package java_35;

public class test {
    public static void main(String[] args) {
        date ngay1 = new date(12, 9, 2022);
        date ngay2 = new date(10, 2, 2001);
        date ngay3 = new date(19, 9, 2022);

        TacGia tg1 = new TacGia("Sy", ngay1);
        TacGia tg2 = new TacGia("thao", ngay2);
        TacGia tg3 = new TacGia("luan", ngay3);

        Sach s1 = new Sach("sach 1", 90, 2022, tg1);
        Sach s2 = new Sach("sach 2", 85, 2022, tg2);
        Sach s3 = new Sach("Sach 3", 50, 2023, tg3);

        
        s1.inTenSach();
        s2.inTenSach();
        s3.inTenSach();

        System.out.println("Kiem tra nam san xuat s1 va s3: " + s1.kiemTraCungNam(s3));
        System.out.println("Kiem tra nam san xuat s1 va s2: " + s1.kiemTraCungNam(s2));

        System.out.println("Gia cua s1 sau khi giam 5% la: " + s1.giaSauKhiGiam(5));
        System.out.println("Gia cua s2 sau khi giam 10% la: "  + s2.giaSauKhiGiam(10));
        System.out.println("Gia cua s3 sau khi giam 15% la: " +s3.giaSauKhiGiam(15));

    }
}
