package java_71;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ViDuGhiText {
    public static void main(String[] args) {
        PrintWriter pw;
        
        try {
            pw = new PrintWriter("D:\\Java_OOP\\java_71\\file.txt","UTF-8");
            pw.println("xin chào");
            pw.print("Dữ liệu: ");
            pw.print(3.14);
            pw.print(" Là số Pi");
            pw.println();
            Students st = new Students(100, "Nguyễn Văn A");
            pw.print(st);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
