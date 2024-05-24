package java_88.View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
    public Draw(){
        this.setBackground(Color.WHITE);
    }
    protected void paintComponent(Graphics G){
        super.paintComponent(G);
        G.setColor(Color.RED);
        G.drawLine(15, 15, 50, 150);
        G.setColor(Color.BLUE);
        G.drawRect(20 , 20, 50, 50);
    }

}

