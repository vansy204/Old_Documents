package Modul;

import java.util.Date;

public class ThiSinh {
    private int maThiSinh;
    private String tenThiSinh;
    private TinhThanh maQueQuan;
    private Date date;
    private boolean gioiTinh;
    private float diemMon1;
    private float diemMon2;
    private float diemMon3;

    public ThiSinh(int maThiSinh, String tenThiSinh, TinhThanh maQueQuan, Date date, boolean gioiTinh, float diemMon1, float diemMon2, float diemMon3) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.maQueQuan = maQueQuan;
        this.date = date;
        this.gioiTinh = gioiTinh;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }

    public ThiSinh() {

    }

    public int getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(int maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public TinhThanh getMaQueQuan() {
        return maQueQuan;
    }

    public void setMaQueQuan(TinhThanh maQueQuan) {
        this.maQueQuan = maQueQuan;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getDiemMon1() {
        return diemMon1;
    }

    public void setDiemMon1(float diemMon1) {
        this.diemMon1 = diemMon1;
    }

    public float getDiemMon2() {
        return diemMon2;
    }

    public void setDiemMon2(float diemMon2) {
        this.diemMon2 = diemMon2;
    }

    public float getDiemMon3() {
        return diemMon3;
    }

    public void setDiemMon3(float diemMon3) {
        this.diemMon3 = diemMon3;
    }
}
