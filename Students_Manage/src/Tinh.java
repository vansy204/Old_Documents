public class Tinh {
    private int maTinh;
    private String tenTinh;

    public Tinh(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }
    public Tinh(){

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

    @Override
    public String toString() {
        return "Tinh{" +
                "maTinh=" + maTinh +
                ", tenTinh='" + tenTinh + '\'' +
                '}';
    }
}
