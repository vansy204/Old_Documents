package java_74;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("D:\\Java_OOP\\java_73\\file.data");
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            SinhVien st = new SinhVien("001", "Nguyễn Văn A", 200, 10);
            oos.writeObject(st);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
