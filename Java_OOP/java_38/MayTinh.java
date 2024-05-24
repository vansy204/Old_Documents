package java_38;

public class MayTinh {
    private HangSanXuat hangSanXuat;
    private Ngay ngaySanXuat;
    private double giaBan;
    private int thoiGianBaoHanh;

    public MayTinh(HangSanXuat hangSanXuat,Ngay ngaySanXuat,double giaBan,int thoiGianBaoHanh){
        this.hangSanXuat = hangSanXuat;
        this.ngaySanXuat = ngaySanXuat;
        this.giaBan = giaBan;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public HangSanXuat getHangSanXuat() {
        return this.hangSanXuat;
    }
    public Ngay getNgaySanXuat() {
        return this.ngaySanXuat;
    }
    public double getGiaBan() {
        return this.giaBan;
    }
    public int getThoiGianBaoHanh() {
        return this.thoiGianBaoHanh;
    }
    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public void setNgaySanXuat(Ngay ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public boolean KiemTraGiaBanThapHon(MayTinh orther){
        return (this.giaBan < orther.giaBan);
    }
    public void tenQuocGiaSanXuat(){
        System.out.println(this.hangSanXuat.getQuocGia().getTenQuocGia() + " co ma la: " + this.hangSanXuat.getQuocGia().getMaQuocGia());
    }

}
