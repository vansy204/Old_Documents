package java_63.main;

import java.util.LinkedList;
import java.util.Queue;



public class Main {
    public static void main(String[] args) {
        Queue <String> danhSachSV = new LinkedList<String>();
        danhSachSV.offer("TITV1");
        danhSachSV.offer("TITV2");
        danhSachSV.offer("TITV3");

        while(true){
            String ten = danhSachSV.poll();
            if(ten == null){
                break;
            }
            System.out.println(ten);
        }
    }
}
