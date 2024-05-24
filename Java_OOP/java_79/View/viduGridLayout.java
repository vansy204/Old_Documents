package java_79.View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class viduGridLayout extends JFrame {
    public viduGridLayout() {
        this.setTitle("ví dụ GridLayout");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        GridLayout gridLayout = new GridLayout();
        GridLayout gridLayout2 = new GridLayout(4, 5);
        GridLayout gridLayout3 = new GridLayout(4, 4, 25, 25);
        this.setLayout(gridLayout3);
        // JButton jButton1 = new JButton("1");
        // JButton jButton2 = new JButton("2");
        // JButton jButton3 = new JButton("3");
        // this.add(jButton1);
        // this.add(jButton2);
        // this.add(jButton3);
        for (int i = 1; i <= 16; i++) {
            JButton jButton = new JButton(i + "");
            this.add(jButton);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        viduGridLayout myWindows = new viduGridLayout();
    }
}
