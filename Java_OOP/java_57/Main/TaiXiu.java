package java_57.Main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
 * Một người chơi sẽ có tài khoản. Người chơi có quyền đă3jt cược số tiền ít hơn hoặc bằng số tiền họ đang có
 * Luật chơi:
 * 1. có 3 viên xúc sắc. mỗi viên xúc sắc có 6 mặt có giá trị từ 1 tới 6.
 *  mỗi lần ra một kết quả = giá trị xx1 + giá trị xx2 + giá trị xx3
 * 
 * nếu:
 * 1. Tổng = 3 hoặc 18 => cái ăn hết, người chơi thua
 * 2. Tổng = (4->10) -> nếu người chơi đặt xỉu thì thắng, ngược lại thua
 * 3. Tổng =(11 -> 17) -> nếu người chơi đặt tài thì thắng, ngược lại thua
 */
public class TaiXiu {
    /**
     * @param args
     */
    public static void main(String[] args) {
        double taiKhoanNguoiChoi = 5000;
        Scanner sc = new Scanner(System.in);
        Locale lc = new Locale("vi", "VN");
        NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
        int luachon;
        do {
            System.out.println("Moi ban lua chon: ");
            System.out.println("1. Tiep tuc choi");
            System.out.println("0. Thoat");
            luachon = sc.nextInt();
            if (luachon == 1) {
                System.out.println("******************************BAT DAU");
                System.out.println("Tai khoan cua ban: " + numf.format(taiKhoanNguoiChoi));
                System.out.println("ban muon cuoc bao nhieu: ");
                double datcuoc;
                // dat cuoc
                do {
                    datcuoc = sc.nextDouble();
                    if (datcuoc <= 0 || datcuoc > taiKhoanNguoiChoi) {
                        System.out.println("So tien ban dat cuoc khong phu hop");

                    }
                } while (datcuoc <= 0 || datcuoc > taiKhoanNguoiChoi);
                int dat;
                // chon tai xiu
                do {
                    System.out.println("1. chon tai");
                    System.out.println("2. chon xiu");
                    System.out.println("chon tai/xiu: ");
                    dat = sc.nextInt();
                    if (dat != 1 && dat != 2) {
                        System.out.println("Nhap lai");
                    }
                } while (dat != 1 && dat != 2);

                // tung xuc xac
                Random xucXac1 = new Random();
                Random xucXac2 = new Random();
                Random xucXac3 = new Random();
                int giaTri1 = xucXac1.nextInt(5) + 1;
                int giaTri2 = xucXac2.nextInt(5) + 1;
                int giaTri3 = xucXac3.nextInt(5) + 1;

                // tinh toan ket qua
                System.out.println("ket qua: " + giaTri1 + " - " + giaTri2 + " - " + giaTri3);
                int tong = giaTri1 + giaTri2 + giaTri3;
                if (tong == 3 || tong == 18) {
                    System.out.println("tong la: " + tong + " => nha cai an het ban da thua");
                    taiKhoanNguoiChoi -= datcuoc;
                    System.out.println("Tai khoan cua ban la" + numf.format(taiKhoanNguoiChoi));
                } else if (tong >= 4 && tong <= 10) {

                    if (dat == 2) {
                        System.out.println("tong la: " + tong + " => ban thang");
                        taiKhoanNguoiChoi += datcuoc;
                        System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
                    } else {
                        System.out.println("tong la: " + tong + " => ban thua");
                        taiKhoanNguoiChoi -= datcuoc;
                        System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
                    }
                } else {

                    if (dat == 1) {
                        System.out.println("tong la: " + tong + " => ban thang");
                        taiKhoanNguoiChoi += datcuoc;
                        System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
                    } else {
                        System.out.println("tong la: " + tong + " => ban thua");
                        taiKhoanNguoiChoi -= datcuoc;
                        System.out.println("Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
                    }
                }
            }

        } while (luachon == 1);
        sc.close();
    }

}
