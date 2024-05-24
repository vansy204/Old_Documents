package java_79.View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class viduBorderLayout extends JFrame {
    public viduBorderLayout() {
        this.setTitle("ví dụ BorderLayout");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        BorderLayout bLayout1 = new BorderLayout();
        BorderLayout bLayout2 = new BorderLayout(15, 15);
        this.setLayout(bLayout2);
        JButton jButton1 = new JButton("nam");
        JButton jButton2 = new JButton("bắc");
        JButton jButton3 = new JButton("đông");
        JButton jButton4 = new JButton("tây");
        JButton jButton5 = new JButton("giữa");
        this.add(jButton1, BorderLayout.SOUTH);
        this.add(jButton2, BorderLayout.NORTH);
        this.add(jButton3, BorderLayout.EAST);
        this.add(jButton4, BorderLayout.WEST);
        this.add(jButton5, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        viduBorderLayout myWindows = new viduBorderLayout();
    }
}
