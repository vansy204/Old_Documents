package Modul;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class TinhThanh {
    private int maTinh;
    private String tenTinh;
    public  static final String fileUrl = "D:\\Java_OOP\\QuanLySinhVien\\src\\Modul\\TinhThanh.txt";
    public TinhThanh(int maTinh,String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }
    public void docDanhSachTinhThanh(){
        File file = new File(fileUrl);
        if(file.isDirectory() && !file.canRead()){
            System.out.println("can't open file");
        }else{
            try {
                InputStream inputStream = new FileInputStream(file);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
