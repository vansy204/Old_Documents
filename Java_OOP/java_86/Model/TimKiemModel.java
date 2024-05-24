package java_86.Model;

public class TimKiemModel {
    private String vanBan;
    private String tuKhoa;
    private String ketQua;

    public TimKiemModel() {
        this.vanBan = "";
        this.tuKhoa = "";
        this.ketQua = "Chưa nhập từ khóa";
    }

    public String getVanBan() {
        return this.vanBan;
    }

    public void setVanBan(String vanBan) {
        this.vanBan = vanBan;
    }

    public String getTuKhoa() {
        return this.tuKhoa;
    }

    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }

    public String getKetQua() {
        return this.ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    public void timKiem(){
        int dem = 0;
        int index =0;
        while(true){
            int i = this.vanBan.indexOf(this.tuKhoa,index);
            if(i==-1){
                break;
            }else{
                dem++;
                index = i+1;
            }
        }
        this.ketQua = "Kết quả có: " + dem + " "+  this.tuKhoa;
    }
}
