package java_51;

public class vidu {
    public static void main(String[] args) {
        String s1 = "xin chao co chu, xin chao cac ban, xin chao!";
        String s2 = "xin chao";
        String s3 = "xin chao 123";
        char c1 = 'i';
        // ham indexOf
        System.out.println("vi tri cua s2 trong s1 la: " + s1.indexOf(s2));
        System.out.println("vi tri cua s2 trong s1 la: " + s1.indexOf(s3));

        // su dung vi tri bat dau
        System.out.println("vi tri cua s2 trong s1 la: " + s1.indexOf(s2,2));

        // tim kiem char
        System.out.println("vi tri cua s2 trong s1 la: " + s1.indexOf(c1,20));

        // lam lastIndexOf
        // nguoc lai voi ham indexOf tim tu trai sang trai thi lastIndexOf tim tu phai sang trai
    }

}
