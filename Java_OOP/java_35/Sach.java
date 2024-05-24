package java_35;

public class Sach {
    private String tenSach;
    private double giaBan;
    private int namSanXuat;
    private TacGia tacGia;

    public Sach(String tenSach,double giaBan,int namSanXuat,TacGia tacGia){
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.namSanXuat = namSanXuat;
        this.tacGia = tacGia;
    }

    public String getTenSach(){
        return this.tenSach;
    }
    public double getGiaBan(){
        return this.giaBan;
    }
    public int getNamSanXuat(){
        return this.namSanXuat;
    }
    public TacGia getTacGia(){
        return this.tacGia;
    }
    public void setTenSach(String tenSach){
        this.tenSach = tenSach;
    }
    public void setGiaBan(double giaBan){
        this.giaBan = giaBan;
    }
    public void setNamSanXuat(int namSanXuat){
        this.namSanXuat= namSanXuat;
    }
    public void setTacGia(TacGia tacGia){
        this.tacGia = tacGia;
    }
    
    public void inTenSach(){
        System.out.println(this.tenSach);
    }
    public boolean kiemTraCungNam(Sach orther){
        return (this.namSanXuat == orther.namSanXuat);
    }
    public double giaSauKhiGiam(double x){
        return this.giaBan - ((this.giaBan *x)/100);
    }
}
