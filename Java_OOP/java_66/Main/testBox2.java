public class testBox2 {
    public static void main(String[] args) {
        box2 bx2 = new box2<Integer>(15);
        System.out.println(bx2.getVal());
        box2 bx3 = new box2<String>("chao");
        System.out.println(bx3.getVal());
    }
}
