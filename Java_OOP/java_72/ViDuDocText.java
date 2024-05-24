package java_72;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 * ViDuDocText
 */
public class ViDuDocText {

    public static void main(String[] args) {
        // // cach 1
        // File f = new File("D:\\Java_OOP\\java_72\\file.txt");
        
        // try {
        //     BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);
        //     // doc het tat ca cac dobng
            
        //     String line = null;
        //     while(true){
        //         line = br.readLine();
        //         if(line == null)break;
        //         else{
        //             System.out.println(line);
        //         }
        //     }
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // cách 2
        File f2 = new File("D:\\Java_OOP\\java_72\\file.txt");
        try {
            List<String> allText = Files.readAllLines(f2.toPath(), StandardCharsets.UTF_8);
            for (String line : allText) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}