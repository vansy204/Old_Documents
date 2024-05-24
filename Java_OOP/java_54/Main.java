package java_54;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(100, "Tran Van Thanh", "22d", 9);
        SinhVien sv2 = new SinhVien(150,"Minh An","22d",6);
        System.out.println(sv1.compareTo(sv2));
    }
} 