package java_61;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luachon;
        do{
            System.out.println("----------------------MENU");
            System.out.println(

                 "1. Them sinh vien vao danh sach.\n"
                + "2.In danh sach sinh vien ra man hinh.\n"
                + "3. Kiem tra danh sach co rong hay khong\n"
                + "4. Lay ra so luong sinh vien trong danh sach\n"
                + "5. Lam rong danh sach\n"
                + "6. Kiem tra sinh vien co ton tai trong danh sach hay khong dua tren ma sinh vien\n"
                + "7. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien\n"
                + "8. Tim kiem tat ca sinh vien dua tren Ten duoc nhap tu ban phim\n"
                + "9. Xuat ra danh sach sinh vien co diem tu cao den thap\n"
                + "0. Thoat khoi chuong trinh"
            );
            System.out.println("----------------------------------");
            System.out.println("Nhap lua chon cua ban: ");
            luachon = sc.nextInt(); 
             
            if(luachon ==1){
                sc.nextLine();
                System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
                
                System.out.println("Nhap ho va ten: "); String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh: "); int namSinh = sc.nextInt();
                System.out.println("Nhap diem trung binh: "); float diemTrungBinh = sc.nextFloat();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                dssv.themSinhVienVaoDanhSach(sv);
                System.out.println("Them sinh vien thanh cong");
                
            }else if(luachon==2){
                dssv.inDanhSachSinhVien();
            }else if(luachon ==3){
                System.out.println("Danh sach co rong khong: " + dssv.isEmpty());
            }else if(luachon ==4){
                System.out.println("Danh sach co: " + dssv.soLuongSinhVien() + " ban");
            }else if(luachon ==5){
                dssv.lamRongDanhSach();
                System.out.println("Lam rong danh sach thanh cong");
            }else if(luachon == 6){
                sc.nextLine();
                System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
                
                System.out.println("Nhap ho va ten: "); String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh: "); int namSinh = sc.nextInt();
                System.out.println("Nhap diem trung binh: "); float diemTrungBinh = sc.nextFloat();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                if(!dssv.kiemTraSuTonTaiCuaSinhVien(sv)){
                    System.out.println("Khong tim thay sinh vien " + hoVaTen);
                }else{
                    System.out.println("Sinh vien "+hoVaTen + " co trong danh sach");
                }
            }else if(luachon == 7){
                sc.nextLine();
                System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
                
                System.out.println("Nhap ho va ten: "); String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh: "); int namSinh = sc.nextInt();
                System.out.println("Nhap diem trung binh: "); float diemTrungBinh = sc.nextFloat();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                if(!dssv.xoaSinhVien(sv)){
                    System.out.println("Khong tim thay sinh vien");
                }else{
                    System.out.println("Xoa thanh cong"); 
                }
            }else if(luachon ==8){
                String ten;
                sc.nextLine();
                System.out.println("Nhap ten ban muon tim: ");
                ten = sc.nextLine();
                dssv.timSinhVien(ten);
            }else if(luachon ==9){
                dssv.sapXep();
                dssv.inDanhSachSinhVien();
            }
        }while(luachon !=0);

    }
}
