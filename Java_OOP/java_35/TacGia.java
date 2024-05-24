package java_35;

public class TacGia {
    private String tenTacGia;
    private date ngaySinh;

    public TacGia(String tenTacGia,date ngaySinh){
        this.tenTacGia = tenTacGia;
        this.ngaySinh = ngaySinh;
    }
    public String getTenTacGia(){
        return this.tenTacGia;
    }
    public date getNgaySinh(){
        return this.ngaySinh;
    }
    public void setTenTacGia(String tenTacGia){
        this.tenTacGia = tenTacGia;
    }
    public void setNgaySinh(date ngaySinh){
        this.ngaySinh = ngaySinh;
    }
    
}
