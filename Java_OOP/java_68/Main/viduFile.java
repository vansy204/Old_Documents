
package java_68.Main;

import java.io.File;
import java.util.Scanner;

public class viduFile {
    File file;

    public viduFile(String tenFile) {
        this.file = new File(tenFile);
    }
    public boolean kiemTraFileCoTheThucThi(){
        return this.file.canExecute();
    }
    public boolean kiemTraFileCoTheDoc(){
        return this.file.canRead();
    }
    public boolean kiemTraFileCoTheGhi(){
        return this.file.canWrite();
    }
    public String inDuongDan(){
        return this.file.getAbsolutePath();
    }
    public String inTenFile(){
        return this.file.getName();
    }
    public void kiemTraLaFolder(){
        if(!this.file.isDirectory()){
            System.out.println("day la tap tin");
        }
        System.out.println("Day la thu muc");
    }
    public void inDanhSachFileCon(){
        if(this.file.isDirectory()){
            System.out.println("cac tep tin con/ thu muc con la: ");
            File[] mangcon = this.file.listFiles();
            for(File file : mangcon){
                System.out.println(file.getAbsolutePath());
            }
        }else{
            System.out.println("Day la tap tin khong co file con");
        }
    }
    public void inCayThuMuc(){
        this.inChiTietCayThuMuc(this.file,1 );
    }
    public void inChiTietCayThuMuc(File f,int bac){
    
        for (int i=0;i<bac;i++){
            System.out.print("\t");    
        }
        System.out.print("|__");
        System.out.println(f.getName());
            if(f.canRead() && f.isDirectory()){
            File[] mangcon = f.listFiles();
            for(File fx : mangcon){
                inChiTietCayThuMuc(fx, bac+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten file: ");
        String tenFile = sc.nextLine();
        viduFile vdf = new viduFile(tenFile);
        int luachon = 0;
        do{
            System.out.println("------------------------------MENU");
            System.out.println("1. Kiem tra file co the thuc thi");
            System.out.println("2. Kiem tra file co the doc");
            System.out.println("3. Kiem tra file co the ghi");
            System.out.println("4. In Duong dan");
            System.out.println("5. In ten file");
            System.out.println("6. Kiem tra file la thu muc hay tap tin");
            System.out.println("7. In danh sach cac file con");
            System.out.println("8 In ra cay thu muc");
            System.out.println("0. Thoat");
            System.out.println("---------------------------------------");
            System.out.print("Nhap lua chon: "); luachon = sc.nextInt();
            if(luachon ==1 ){
                System.out.println("File co the thuc thi khong: " + vdf.kiemTraFileCoTheThucThi());
            }else if(luachon == 2){
                System.out.println("File co the doc khong: " + vdf.kiemTraFileCoTheDoc());
            }else if(luachon == 3){
                System.out.println("File co the ghi khong: " + vdf.kiemTraFileCoTheGhi());
            }else if(luachon == 4){
                System.out.println("Duong dan cua file la: " + vdf.inDuongDan());
            }else if(luachon ==5){
                System.out.println("Ten cua file la: " + vdf.inTenFile());
            }
            else if(luachon == 6){
                vdf.kiemTraLaFolder();
            }else if(luachon ==7){
                vdf.inDanhSachFileCon();
            }else if(luachon==8){
                vdf.inCayThuMuc();
            }else{
                break;
            }
            sc.nextLine();
        }while(luachon !=0);
    }
}
