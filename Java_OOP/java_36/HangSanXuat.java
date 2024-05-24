package java_36;

public class HangSanXuat {
    private String tenHangSanXuat;
    private String quocGia;

    public HangSanXuat(String tenHangSanXuat,String quocGia){
        this.tenHangSanXuat = tenHangSanXuat;
        this.quocGia = quocGia;
    }

    public String getTenHangSanXuat(){
        return this.tenHangSanXuat;
    }
    public String getQuocGia(){
        return this.quocGia;
    }
    public void setTenHangSanXuat(String tenHangSanXuat){
        this.tenHangSanXuat = tenHangSanXuat;
    }
    public void setQuocGia(String quocGia){
        this.quocGia = quocGia;
    }
}
