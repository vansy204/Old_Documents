package java_46;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test cau a:");
        CasioFX500  fx500 = new CasioFX500();
        ViNaCal500 vnc500 = new ViNaCal500();
        System.out.println("5 +3 = " + fx500.cong(5, 3));
        System.out.println("5 - 3 = " + fx500.tru(5, 3));
        System.out.println("5 * 3 = " + vnc500.nhan(5, 3));
        System.out.println("5 / 0 = " + vnc500.chia(5, 0));


        System.out.println("Test cau b: ");
        double[] arr1 = new double[] {5,1,3,4,5,7,0};
        double[] arr2 = new double[] {5,2,1,6,8,6,2,9,0};
        sapXepChen sxc = new sapXepChen();
        sapXepChon sxch = new sapXepChon();

        sxc.sapXepTang(arr1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i] +" ");
        }
        System.out.println();
        sxch.sapXepGiam(arr2);
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] +" ");
        }
        System.out.println("Test cau c: ");
        PhanMemMayTinh pm = new PhanMemMayTinh();
        System.out.println("5+10= " + pm.cong(5, 10));
        double[] arr3 = new double[] {3,12,67,78,4};
        pm.sapXepGiam(arr3);
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i] +" ");
        }
    }

}
