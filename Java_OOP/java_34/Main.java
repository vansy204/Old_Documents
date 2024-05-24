package java_34;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        myDate md1 = new myDate(15, 5, 2012);
        myDate md2 = new myDate(11, 5, 2012);
        myDate md3 = new myDate(15, 5, 2012);

        System.out.println("md1 so sanh voi md2: " + md1.equals(2));
        System.out.println("md1 so sanh voi md3: " + md1.equals(md3));

        System.out.println("hashcode md1: " + md1.hashCode());
        System.out.println("hashcode md2: " + md2.hashCode());
        System.out.println("hashcode md3: " + md3.hashCode());
    }
    
}
