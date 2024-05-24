package java_88.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class view extends JFrame{
    public view(){
        this.setTitle("Draw");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Draw draw = new Draw();
        this.setLayout(new BorderLayout());
        this.add(draw,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new view();
    }
}
