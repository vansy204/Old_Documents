package java_79.View;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class viduFlowLayout extends JFrame {
    public viduFlowLayout() {

        this.setTitle("Flow Layout");
        this.setSize(600, 400);

        this.setLocationRelativeTo(null);
        FlowLayout flowLayout = new FlowLayout();
        FlowLayout flowLayout_1 = new FlowLayout(FlowLayout.CENTER, 50, 50);
        FlowLayout flowLayout_2 = new FlowLayout(FlowLayout.LEADING);
        this.setLayout(flowLayout_1);
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
        // add thanh phan
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        viduFlowLayout mywin = new viduFlowLayout();

    }
}
