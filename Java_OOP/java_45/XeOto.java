package java_45;

public class XeOto extends PhuongTienDiChuyen{
    private String loaiNhienLieu;
    public XeOto( String loaiNhienLieu,HangSanXuat hangSanXuat){
        super("Xe Oto",hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }
    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }
    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }
    @Override
    public double layVanToc(){
        return 75;
    }
}
