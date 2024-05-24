package java_61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList <SinhVien> danhSach;

    public DanhSachSinhVien(){
        this.danhSach = new ArrayList<SinhVien>();
    }
    public DanhSachSinhVien(ArrayList<SinhVien> danhSach){
        this.danhSach = danhSach;
    }
    public void themSinhVienVaoDanhSach(SinhVien sv){
        this.danhSach.add(sv);
    }
    public boolean isEmpty(){
        return (this.danhSach.isEmpty());
    }
    public int soLuongSinhVien(){
        return (this.danhSach.size());
    }
    public void lamRongDanhSach(){
        this.danhSach.clear();
    }
    public boolean kiemTraSuTonTaiCuaSinhVien(SinhVien sv){
        return this.danhSach.contains(sv);
    }
    public boolean xoaSinhVien(SinhVien sv){
        return this.danhSach.remove(sv);
    }
    public void inDanhSachSinhVien(){
        for(SinhVien sinhVien : danhSach){
            System.out.println(sinhVien);
        }
    }
    public void timSinhVien(String ten){
        for(SinhVien sinhVien : danhSach){
            if(sinhVien.getHoVaTen().indexOf(ten)>=0){
                System.out.println(sinhVien);
            }
        }
    }
    public void sapXep(){
        Collections.sort(this.danhSach,new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien sv1,SinhVien sv2){
                if(sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh())return -1;
                else if(sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh())return 1;
                else return 0;
            }
        });
    }
}
